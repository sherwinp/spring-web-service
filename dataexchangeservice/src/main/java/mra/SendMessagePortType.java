package mra;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.w3c.dom.Element;

@Endpoint
public class SendMessagePortType {

    public static final String NAMESPACE_URI = "urn:publicid:-:US:CBP:MRA:WEBSERVICE:1.0";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart="MRA:Envelope")
    public @ResponsePayload Object handleGetObjectRequest(@RequestPayload Element request) {
        System.out.println("handleGetObjectRequest()");
        // TODO: Go to service.getPerson(request)
        return new Object();
    }
}