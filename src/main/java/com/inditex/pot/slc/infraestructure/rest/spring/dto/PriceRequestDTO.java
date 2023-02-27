package com.inditex.pot.slc.infraestructure.rest.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriceRequestDTO {
    private LocalDateTime date;
    private int productId;
    private int brand_id;
}
