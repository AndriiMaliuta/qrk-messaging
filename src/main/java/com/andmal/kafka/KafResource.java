package com.andmal.kafka;

import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.resteasy.reactive.RestStreamElementType;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("kafka")
public class KafResource {
    @Inject
    @Channel("kafka-requests")
//    Emitter<String> emitter;
    Multi<String> messages;

    @GET
    @Path("/messages")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @RestStreamElementType(MediaType.TEXT_PLAIN)
    public Multi<String> stream() {
        return messages;
    }

//    @POST
//    @Path("/request")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String createRequest() {
//        UUID uuid = UUID.randomUUID();
//        emitter.send(uuid.toString());
//        return uuid.toString();
//    }


}
