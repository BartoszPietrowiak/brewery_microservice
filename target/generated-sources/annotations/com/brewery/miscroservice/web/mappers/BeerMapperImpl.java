package com.brewery.miscroservice.web.mappers;

import com.brewery.miscroservice.domain.Beer;
import com.brewery.miscroservice.domain.Beer.BeerBuilder;
import com.brewery.miscroservice.web.model.BeerDto;
import com.brewery.miscroservice.web.model.BeerDto.BeerDtoBuilder;
import com.brewery.miscroservice.web.model.BeerStyleEnum;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-20T09:48:40+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.5 (Private Build)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDtoBuilder beerDto = BeerDto.builder();

        if ( beer.getVersion() != null ) {
            beerDto.version( beer.getVersion().intValue() );
        }
        beerDto.createdDate( dateMapper.asOffsetDateTime( beer.getCreatedDate() ) );
        beerDto.beerName( beer.getBeerName() );
        if ( beer.getBeerStyle() != null ) {
            beerDto.beerStyle( Enum.valueOf( BeerStyleEnum.class, beer.getBeerStyle() ) );
        }
        beerDto.upc( beer.getUpc() );
        beerDto.price( beer.getPrice() );

        return beerDto.build();
    }

    @Override
    public Beer beerDtoToBeer(BeerDto beer) {
        if ( beer == null ) {
            return null;
        }

        BeerBuilder beer1 = Beer.builder();

        if ( beer.getVersion() != null ) {
            beer1.version( beer.getVersion().longValue() );
        }
        beer1.createdDate( dateMapper.asTimestamp( beer.getCreatedDate() ) );
        beer1.beerName( beer.getBeerName() );
        if ( beer.getBeerStyle() != null ) {
            beer1.beerStyle( beer.getBeerStyle().name() );
        }
        beer1.upc( beer.getUpc() );
        beer1.price( beer.getPrice() );

        return beer1.build();
    }
}
