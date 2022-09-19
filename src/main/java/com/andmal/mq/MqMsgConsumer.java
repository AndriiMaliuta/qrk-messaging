package com.andmal.mq;

import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import java.time.Duration;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
public class MqMsgConsumer {
    public static final Logger LOG = LoggerFactory.getLogger(MqMsgConsumer.class);

    @Incoming("words-in")
//    @Blocking
//    @Transactional
    public void consume(String msg) {
        //        MyMessage msg = p.mapTo(MyMessage.class);
        LOG.info(msg.toString());
    }

    @ApplicationScoped
    public static class Generator {

        @Outgoing("words-out")
        public Multi<String> messages() {
            AtomicInteger count = new AtomicInteger();
            return Multi.createFrom().ticks().every(Duration.ofMillis(1000))
                    .map(l -> String.valueOf(count.incrementAndGet()))
                    .onOverflow().drop();
        }

    }

    //    @Incoming("words")
//    public CompletionStage<Void> consume(Message<String> msg) {
//        Optional<IncomingRabbitMQMetadata> metadata = incoming.getMetadata(IncomingRabbitMQMetadata.class);
//        metadata.ifPresent(meta -> {
//            final Optional<String> contentEncoding = meta.getContentEncoding();
//            final Optional<String> contentType = meta.getContentType();
//            final Optional<String> correlationId = meta.getCorrelationId();
//            final Optional<ZonedDateTime> creationTime = meta.getCreationTime(ZoneId.systemDefault());
//            final Optional<Integer> priority = meta.getPriority();
//            final Optional<String> replyTo = meta.getReplyTo();
//            final Optional<String> userId = meta.getUserId();
//
//            // Access a single String-valued header
//            final Optional<String> stringHeader = meta.getHeader("my-header", String.class);
//
//            // Access all headers
//            final Map<String,Object> headers = meta.getHeaders();
//            // ...
//        });
//        return msg.ack();
//    }
}


