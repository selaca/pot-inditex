package com.inditex.pot.slc.infraestructure.dbsql.spring.mapper;

import com.inditex.pot.slc.domain.Price;
import com.inditex.pot.slc.infraestructure.dbsql.spring.entities.PriceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPriceEntityMapper {

    public Price toDomain(PriceEntity priceEntity);
    public PriceEntity toDbo(Price price);
}
