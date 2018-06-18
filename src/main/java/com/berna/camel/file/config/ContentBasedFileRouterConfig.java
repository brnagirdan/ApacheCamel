package com.berna.camel.file.config;


import com.berna.camel.file.ContentBasedFileRouter;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ContentBasedFileRouterConfig extends CamelConfiguration{

    @Bean
    ContentBasedFileRouter getContentBasedFileRouter(){
        return new ContentBasedFileRouter();
    }


    public List<RouteBuilder> routes(){
        return (List<RouteBuilder>) getContentBasedFileRouter();
    }

}
