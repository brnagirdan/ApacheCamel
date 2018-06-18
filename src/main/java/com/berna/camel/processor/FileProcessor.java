package com.berna.camel.processor;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FileProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String orginalFileContent= exchange.getIn().getBody(String.class);
        String upperCaseFileContent =orginalFileContent.toUpperCase();
        exchange.getIn().setBody(upperCaseFileContent);
    }
}
