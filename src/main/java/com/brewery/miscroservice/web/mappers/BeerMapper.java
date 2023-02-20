package com.brewery.miscroservice.web.mappers;

import com.brewery.miscroservice.domain.Beer;
import com.brewery.miscroservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses={DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beer);
}
