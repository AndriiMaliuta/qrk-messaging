//package com.andmal.kafka;
//
//import io.smallrye.reactive.messaging.annotations.Blocking;
//import org.eclipse.microprofile.reactive.messaging.Incoming;
//import org.eclipse.microprofile.reactive.messaging.Outgoing;
//
//import javax.enterprise.context.ApplicationScoped;
//
//@ApplicationScoped
//public class WordProcessor {
//
//    @Incoming("requests")
//    @Outgoing("requests-out")
//    @Blocking
//    public String process(String quoteRequest) throws InterruptedException {
//        // simulate some hard working task
//        Thread.sleep(200);
//        return "Hello Kafka";
//    }
//}
