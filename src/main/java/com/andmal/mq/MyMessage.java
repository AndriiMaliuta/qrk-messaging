package com.andmal.mq;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class MyMessage {
    public String id;
    public String body;

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
