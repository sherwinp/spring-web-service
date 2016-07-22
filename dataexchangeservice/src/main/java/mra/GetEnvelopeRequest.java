package mra;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "GetEnvelopeRequest", namespace = SendMessagePortType.NAMESPACE_URI)
@XmlAccessorType(XmlAccessType.FIELD)
public class GetEnvelopeRequest {
    @XmlElement
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

