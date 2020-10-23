package com.challenge;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/exchange/dolar")
public class DolarExchangeResource {

    @Inject CurrencyService currencyService;

    @GET
    @Path("/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dolarExchange(@PathParam("date") String date) {

        if(date.isEmpty() || date.matches("^(0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])[-](19|20)\\d{2}$") == false) {
            return Response.status(400).build();
        }

        return Response.ok("hello").build();
    }

    @POST
    @Path("/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retreiveDolarExchange(@PathParam("date") String date) {

        if(date.isEmpty() || date.matches("^(0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])[-](19|20)\\d{2}$") == false) {
            return Response.status(400).build();
        }

        return Response.ok("hello").build();
    }
}