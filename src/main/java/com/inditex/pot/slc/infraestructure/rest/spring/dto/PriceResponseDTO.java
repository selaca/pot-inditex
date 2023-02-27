package com.inditex.pot.slc.infraestructure.rest.spring.dto;

import com.inditex.pot.slc.utils.exceptions.model.Error;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriceResponseDTO {
    private PriceDTO data;
    private Error errors;
}
