package com.inditex.pot.slc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Price {
    private long id;
    private int product_id;
    private int brand_id;
    private int price_list;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private int priority;
    private float price;
    private String curr;
}
