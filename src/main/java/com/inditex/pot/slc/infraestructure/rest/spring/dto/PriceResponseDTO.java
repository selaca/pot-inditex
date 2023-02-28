package com.inditex.pot.slc.infraestructure.rest.spring.dto;

import com.inditex.pot.slc.utils.commons.bean.Response;
import com.inditex.pot.slc.utils.commons.exceptions.model.Error;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
public class PriceResponseDTO {
    private PriceDTO data;
    private Error errors;
}
