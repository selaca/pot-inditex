package com.inditex.pot.slc.application.repository;

import com.inditex.pot.slc.domain.Price;

import java.time.LocalDateTime;

public interface IPriceRepository {
    Price findPriceByDate(
        LocalDateTime date,
        int product_id,
        int brand_id);
}
