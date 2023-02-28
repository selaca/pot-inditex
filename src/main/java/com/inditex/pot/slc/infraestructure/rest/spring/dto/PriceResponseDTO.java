package com.inditex.pot.slc.infraestructure.rest.spring.dto;

import com.inditex.pot.slc.utils.commons.exceptions.model.Error;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PriceResponseDTO {
    private PriceDTO data;
    private Error errors;
}
