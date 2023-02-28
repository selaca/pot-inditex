package com.inditex.pot.slc.infraestructure.dbsql.spring.repository;

import com.inditex.pot.slc.application.repository.IPriceRepository;
import com.inditex.pot.slc.domain.Price;
import com.inditex.pot.slc.infraestructure.dbsql.spring.entities.PriceEntity;
import com.inditex.pot.slc.infraestructure.dbsql.spring.mapper.IPriceEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class PriceRepository implements IPriceRepository {
    private final SpringPriceRepository springPriceRepository;
    private final IPriceEntityMapper priceEntityMapper;

    public Price findPriceByDate(
            LocalDateTime date,
            int productId,
            int brandId) {

        return
            priceEntityMapper.toDomain(
                springPriceRepository
                    .findPriceByDate(date, productId, brandId));
    }
}
