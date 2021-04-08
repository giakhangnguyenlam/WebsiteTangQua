package com.swcat.giftapp.Jersey;

import javax.ws.rs.ApplicationPath;

import com.swcat.giftapp.REST.demoREST;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(ServletResponseFilter.class);

        // register REST class here
        register(demoREST.class);
    }
}
