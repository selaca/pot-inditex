package com.inditex.pot.slc.application.service;

import com.inditex.pot.slc.application.repository.IPriceRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PriceService {
    private final IPriceRepository priceRepository;
}
