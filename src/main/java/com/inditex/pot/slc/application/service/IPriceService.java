package com.inditex.pot.slc.application.service;

import com.inditex.pot.slc.domain.Price;

import java.time.LocalDateTime;

public interface IPriceService {

    public Price getPriceByDate(
            LocalDateTime date,
            int productId,
            int brandId);
}
