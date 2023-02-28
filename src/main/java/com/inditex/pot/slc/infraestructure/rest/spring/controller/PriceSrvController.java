package com.inditex.pot.slc.infraestructure.rest.spring.controller;

import com.inditex.pot.slc.application.service.impl.PriceService;
import com.inditex.pot.slc.infraestructure.rest.spring.dto.PriceDTO;
import com.inditex.pot.slc.infraestructure.rest.spring.dto.PriceRequestDTO;
import com.inditex.pot.slc.infraestructure.rest.spring.dto.PriceResponseDTO;
import com.inditex.pot.slc.infraestructure.rest.spring.mapper.IPriceMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("inditex/prices/v1")
@Api(value = "/inditext/prices/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@Validated
public class PriceSrvController {

    private final PriceService priceService;
    private final IPriceMapper mapper;

    @ApiOperation(
            value = "/product-price",
            notes = "Obtencion de los 5 pokemons con atributo maximo pasado como parámetro, con attributo game_indices.version_name = 'red' ")
    @ApiResponses( {
        @ApiResponse(
            code = 200,
            message = "OK",
            response= PriceResponseDTO.class),
        @ApiResponse(
            code = 400,
            message = "Bad request",
            response= PriceResponseDTO.class),
        @ApiResponse(
            code = 500,
            message = "Internal server Error",
            response= PriceResponseDTO.class) }
    )
    @PostMapping(
        value = "/product-price",
        consumes = { "application/json"},
        produces = { "application/json" })
    ResponseEntity<PriceResponseDTO> getProductPrice(@Valid @RequestBody PriceRequestDTO priceRequest) {

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
