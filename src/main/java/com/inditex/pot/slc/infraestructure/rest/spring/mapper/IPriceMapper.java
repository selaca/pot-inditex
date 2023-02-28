package com.inditex.pot.slc.infraestructure.rest.spring.mapper;

import com.inditex.pot.slc.domain.Price;
import com.inditex.pot.slc.infraestructure.rest.spring.dto.PriceDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPriceMapper {

    public PriceDTO toDTO (Price domainPrice);
    public Price toDomain(PriceDTO priceDTO);
}
