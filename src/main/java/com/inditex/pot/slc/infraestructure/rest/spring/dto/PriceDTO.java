package com.inditex.pot.slc.infraestructure.rest.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PriceDTO {
    private int product_id;
    private int brand_id;
    private int price_list;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH.mm.ss")
    private LocalDateTime start_date;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH.mm.ss")
    private LocalDateTime end_date;
    private float price;
}
