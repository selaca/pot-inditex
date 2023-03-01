package com.inditex.pot.slc.infraestructure.rest.spring.controller;

import com.inditex.pot.slc.application.service.IPriceService;
import com.inditex.pot.slc.infraestructure.config.spring.aspect.logging.annotation.Logging;
import com.inditex.pot.slc.infraestructure.rest.spring.dto.PriceDTO;
import com.inditex.pot.slc.infraestructure.rest.spring.dto.PriceRequestDTO;
import com.inditex.pot.slc.infraestructure.rest.spring.dto.PriceResponseDTO;
import com.inditex.pot.slc.infraestructure.rest.spring.mapper.IPriceMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/inditex/prices")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@Validated
public class PriceSrvController {

    private final IPriceService priceService;
    private final IPriceMapper mapper;


    @Operation(summary = "Gets product prices based on a date")
    @Parameters
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Found product price",
            content = { @Content(mediaType = "application/json", schema = @Schema(implementation = PriceResponseDTO.class))}
        )
    })
    @PostMapping(
        value = "/product-price",
        consumes = { "application/json"},
        produces = { "application/json" })
    @Logging("INFO")
    ResponseEntity<PriceResponseDTO> getProductPrice(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Request object")
            @RequestBody PriceRequestDTO priceRequest) {

        PriceDTO priceDTO = mapper.toDTO(
            priceService.getPriceByDate(
                priceRequest.getDate(),
                priceRequest.getProductId(),
                priceRequest.getBrandId()));

        return
            ResponseEntity
                .ok()
                .body(
                    PriceResponseDTO.builder().data(priceDTO).build());
    }

}
