package com.inditex.pot.slc.application.service.impl;

import com.inditex.pot.slc.application.repository.IPriceRepository;
import com.inditex.pot.slc.application.service.IPriceService;
import com.inditex.pot.slc.domain.Price;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class PriceService implements IPriceService {
    private final IPriceRepository priceRepository;

    public Price getPriceByDate(
        LocalDateTime date,
        int productId,
        int brandId) {

        return priceRepository.findPriceByDate(
            date,
            productId,
            brandId);
    }
}
