package com.inditex.pot.slc.infraestructure.rest.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Validated
public class PriceRequestDTO {
    @NotNull
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH.mm.ss")
    private LocalDateTime date;
    @NotNull
    private int productId;
    @NotNull
    private int brandId;
}
