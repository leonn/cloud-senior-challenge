package com.challenge;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class DolarExchangeResourceTest {

    @Test
    public void testWrongParameterPost() {
        given()
          .when().post("/exchange/dolar/2020-10-22")
          .then()
             .statusCode(400);
    }
    @Test
    public void testWrongParameterGet() {
        given()
          .when().get("/exchange/dolar/2020-10-22")
          .then()
             .statusCode(400);
    }

}