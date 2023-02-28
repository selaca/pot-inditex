package com.inditex.pot.slc.infraestructure.dbsql.spring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PriceEntity {
    @Id
    private long id;

    private int brand_id;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private int price_list;
    private int product_id;
    private int priority;
    private float price;
    private String curr;
}
