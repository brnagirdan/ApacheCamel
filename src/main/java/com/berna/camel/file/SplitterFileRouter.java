package com.berna.camel.file;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;


/**
 * The splitter allows us to split the incoming message into a number of pieces and processing each of them individually.
 */
public class SplitterFileRouter extends RouteBuilder {
    private static final String SOURCE_FOLDER = "src/test/source-folder";
    private static final String DESTINATION_FOLDER = "src/test/destination-folder";

    @Override
    public void configure() throws Exception {
        from("file://" + SOURCE_FOLDER + "?delete=true").split(body().convertToString().tokenize("\n")).setHeader(Exchange.FILE_NAME, body()).to("file://" + DESTINATION_FOLDER);

    }
}
