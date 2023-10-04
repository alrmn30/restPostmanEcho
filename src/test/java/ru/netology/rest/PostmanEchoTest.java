package ru.netology.rest;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
    public void shouldReturnSendDataLat() {
        given()
                .baseUri("https://postman-echo.com")
                .body("some data") // отправляемые данные (заголовки и query можно выставлять аналогично)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data",  equalTo("some data"));
        ;
    }

    @Test
    public void shouldReturnSendDataCyr() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("какой-то текст")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data",  equalTo("какой-то текст"))
        ;
    }
}
