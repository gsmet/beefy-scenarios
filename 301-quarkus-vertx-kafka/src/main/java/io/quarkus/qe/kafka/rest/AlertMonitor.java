package io.quarkus.qe.kafka.rest;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.resteasy.annotations.SseElementType;
import org.reactivestreams.Publisher;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/monitor")
public class AlertMonitor {

    @Inject
    @Channel("login-alerts")
    Publisher<String> alerts;

    @GET
    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @SseElementType("application/json")
    public Publisher<String> stream() {
        return alerts;
    }

}
