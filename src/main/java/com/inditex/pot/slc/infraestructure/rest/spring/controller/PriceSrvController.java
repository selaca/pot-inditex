package com.inditex.pot.slc.infraestructure.rest.spring.controller;

import com.inditex.pot.slc.infraestructure.rest.spring.dto.PriceRequestDTO;
import com.inditex.pot.slc.infraestructure.rest.spring.dto.PriceResponseDTO;
import com.sun.istack.NotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("inditex/prices/v1")
@Api(value = "/inditext/prices/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@Validated
public class PriceSrvController {

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
    ResponseEntity<PriceResponseDTO> getProductPrice(@NotNull @RequestBody PriceRequestDTO priceRequest) {
        return ResponseEntity.ok().body(null);
    }

}
