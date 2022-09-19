package com.andmal;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BasicProperties;
import com.rabbitmq.client.impl.AMQBasicProperties;
import io.smallrye.mutiny.Multi;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.rabbitmq.RabbitMQPublisher;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/msg")
public class MsgResource {

    @Channel("words-in")
//    Emitter<String> emitter;
    Multi<String> words;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Multi<String> msg() {
//        AMQP.BasicProperties basicProperties = new AMQP.BasicProperties.Builder().build();
//        Handler<AsyncResult<Void>> resultHandler = r -> {
//            r.otherwise();
//        };
//        rabbitMQPublisher.publish("exchange", "routingKey",
//                basicProperties,
//                Buffer.buffer("some message"),
//                resultHandler
//                );
//        emitter.send(UUID.randomUUID().toString());
        return words;
    }
}