package com.andmal;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BasicProperties;
import com.rabbitmq.client.impl.AMQBasicProperties;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.rabbitmq.RabbitMQPublisher;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/msg")
public class MsgResource {

//    RabbitMQPublisher rabbitMQPublisher;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String msg() {
//        AMQP.BasicProperties basicProperties = new AMQP.BasicProperties.Builder().build();
//        Handler<AsyncResult<Void>> resultHandler = r -> {
//            r.otherwise();
//        };
//        rabbitMQPublisher.publish("exchange", "routingKey",
//                basicProperties,
//                Buffer.buffer("some message"),
//                resultHandler
//                );
        return "Hello from RESTEasy Reactive";
    }
}