package com.disney.studios;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.disney.studios.controller.DogPictureControllerImpl;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        
       register(DogPictureControllerImpl.class);
    }
}