package com.inditex.pot.slc;

import com.inditex.pot.slc.infraestructure.config.spring.SlcApplication;
import com.inditex.pot.slc.infraestructure.rest.spring.dto.PriceRequestDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest(
    classes = SlcApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SlcApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    private final DateTimeFormatter dateTimeFormatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss");

    @Test
    @Order(1)
    void test1() {
        PriceRequestDTO priceRequestDTO =
            new PriceRequestDTO(
                    LocalDateTime.parse(
                        "2020-06-14 10.00.00",
                        dateTimeFormatter),
                35455,
                1);

        webTestClient.post().uri("/v1/inditex/prices/product-price")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(Mono.just(priceRequestDTO), PriceRequestDTO.class)
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.data").isNotEmpty()
            .jsonPath("$.data.price").isEqualTo(35.5);
    }

    @Test
    @Order(2)
    void test2() {
        PriceRequestDTO priceRequestDTO =
            new PriceRequestDTO(
                LocalDateTime.parse(
                    "2020-06-14 16.00.00",
                    dateTimeFormatter),
              35455,
                1);

        webTestClient.post().uri("/v1/inditex/prices/product-price")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(Mono.just(priceRequestDTO), PriceRequestDTO.class)
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.data").isNotEmpty()
            .jsonPath("$.data.price").isEqualTo(25.45);
    }

    @Test
    @Order(3)
    void test3() {
        PriceRequestDTO priceRequestDTO =
            new PriceRequestDTO(
                LocalDateTime.parse(
                    "2020-06-14 21.00.00",
                    dateTimeFormatter),
                35455,
                1);

        webTestClient.post().uri("/v1/inditex/prices/product-price")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(Mono.just(priceRequestDTO), PriceRequestDTO.class)
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.data").isNotEmpty()
            .jsonPath("$.data.price").isEqualTo(35.5);
    }

    @Test
    @Order(4)
    void test4() {
        PriceRequestDTO priceRequestDTO =
            new PriceRequestDTO(
                LocalDateTime.parse(
                    "2020-06-15 10.00.00",
                    dateTimeFormatter),
                35455,
                1);

        webTestClient.post().uri("/v1/inditex/prices/product-price")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(Mono.just(priceRequestDTO), PriceRequestDTO.class)
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.data").isNotEmpty()
            .jsonPath("$.data.price").isEqualTo(30.5);
    }

    @Test
    @Order(5)
    void test5() {
        PriceRequestDTO priceRequestDTO =
            new PriceRequestDTO(
                LocalDateTime.parse(
                    "2020-06-16 21.00.00",
                    dateTimeFormatter),
                35455,
                1);

        webTestClient.post().uri("/v1/inditex/prices/product-price")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(Mono.just(priceRequestDTO), PriceRequestDTO.class)
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.data").isNotEmpty()
            .jsonPath("$.data.price").isEqualTo(38.95);
    }

    @Test
    @Order(6)
    void test6() {
        PriceRequestDTO priceRequestDTO =
            new PriceRequestDTO(
                LocalDateTime.parse(
                    "2020-06-16 21.00.00",
                    dateTimeFormatter),
                35455,
                2);

        webTestClient.post().uri("/v1/inditex/prices/product-price")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(Mono.just(priceRequestDTO), PriceRequestDTO.class)
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.data").isEmpty();
    }

}
