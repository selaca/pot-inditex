package com.inditex.pot.slc.application.service.impl;

import com.inditex.pot.slc.application.repository.IPriceRepository;
import com.inditex.pot.slc.application.service.IPriceService;
import com.inditex.pot.slc.domain.Price;
import com.inditex.pot.slc.utils.commons.exceptions.FunctionalException;
import com.inditex.pot.slc.utils.commons.exceptions.model.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class PriceService implements IPriceService {
    private final IPriceRepository priceRepository;

    public Price getPriceByDate(
            LocalDateTime date,
            int productId,
            int brandId) {

        try {
            return
                priceRepository.findPriceByDate(
                    date,
                    productId,
                    brandId);
        } catch(Exception ex) {
            throw new FunctionalException(
                "Application/Domain Exception",
                ex.getMessage(),
                Type.ERROR,
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
