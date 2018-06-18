package com.berna.camel.file;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class DeadLetterFileRouter extends RouteBuilder {
    private static final String SOURCE_FOLDER = "/src/test/source-folder/";

    /**
     * Allows us to control what happens with a message once it fails to be delivered.
     * Trying again with a certain delay will help and a message will get processed.
     *
     * @throws Exception
     */
    public void configure() throws Exception {
        errorHandler(deadLetterChannel("log:dead?level=ERROR").maximumRedeliveries(3)
                .redeliveryDelay(1000).retryAttemptedLogLevel(LoggingLevel.ERROR));

        from("file://" + SOURCE_FOLDER + "?delete=true")
                .process(exchange -> {
                    throw new IllegalArgumentException("Exception thrown");
                });
    }
}
