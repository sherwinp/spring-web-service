package dataservice;

import java.io.Serializable;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.UUID;
import java.util.Date;
import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Inbound")
public class Inbound implements Serializable{
	
	@Column(columnDefinition="CHAR(16) FOR BIT DATA", length=16, updatable=false, nullable=false)
	private byte[] messageId;
	
	@Id
	@SequenceGenerator( name = "messageSequence", sequenceName = "messageSequence", allocationSize = 10, initialValue = 1 )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "messageSequence" )
	private BigInteger messageSequence;
	
	@Column(name = "DATE_FIELD")
	@Temporal(TemporalType.DATE )
	private java.util.Date dateField;
	    
	@Column(name = "DATETIME_FIELD")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Calendar datetimeField;
	    
	@Column(name = "TIMESTAMP_FIELD", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date timestampField;
	
  @PrePersist
  protected void onCreate() {
	  dateField = Calendar.getInstance().getTime();
	  datetimeField = Calendar.getInstance();
  }

  @PreUpdate
  protected void onUpdate() {
	  datetimeField = Calendar.getInstance();
  }

	public UUID NewMessageId(){
		return java.util.UUID.randomUUID();
	}
	public void setMessageId(UUID someId){
		ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
	    bb.putLong(someId.getMostSignificantBits());
	    bb.putLong(someId.getLeastSignificantBits());
	    messageId = bb.array();
	}
	public UUID getMessageId(){
		return java.util.UUID.nameUUIDFromBytes(messageId);
	}
}
