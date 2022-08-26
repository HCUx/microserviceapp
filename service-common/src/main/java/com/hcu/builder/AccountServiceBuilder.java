package com.hcu.builder;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;

public class AccountServiceBuilder {
    private AccountServiceBuilder() {
    }

    public static <T> T createClient(Class<T> type, String uri) {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(type))
                .logLevel(Logger.Level.HEADERS)
                .target(type, uri);
    }
}
