package com.challenge;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
// import com.squareup.okhttp.OkHttpClient;

@Path("/exchange/dolar")
@Produces(MediaType.APPLICATION_JSON)
public class DolarExchangeResource {

    @Inject CurrencyService currencyService;

    @GET
    @Path("/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dolarExchange(@PathParam("date") String date) {

        if(date.isEmpty() || date.matches("^(0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])[-](19|20)\\d{2}$") == false) {
            return Response.status(400).build();
        }

        // OkHttpClient client = new OkHttpClient().newBuilder().build();
        // Request request = new Request.Builder() 
        //     .url("https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/CotacaoDolarDia(dataCotacao=@dataCotacao)?@dataCotacao='10-22-2020'&$format=json")
        //     .method("GET", null)
        //     .build();

        // Response response = client.newCall(request).execute();

        Currency c = new Currency();
        
        /// TODO parse http response and fill data
        // c.setTimestamp();
        // c.setExchangeRateDate();
        // c.setExchangeRateDatetime();
        // c.setSellRate();
        // c.setBuyRate();
        // c.set();
        currencyService.add(currency, "dolar");

        return Response.ok(currency).build();
    }

    @POST
    @Path("/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retreiveDolarExchange(@PathParam("date") String date) {

        if(date.isEmpty() || date.matches("^(0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])[-](19|20)\\d{2}$") == false) {
            return Response.status(400).build();
        }

        return Response.ok(currencyService.list("dolar")).build();
    }
}