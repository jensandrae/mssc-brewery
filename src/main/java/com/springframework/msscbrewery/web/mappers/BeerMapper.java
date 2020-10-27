package com.springframework.msscbrewery.web.mappers;

import com.springframework.msscbrewery.domain.Beer;
import com.springframework.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * Created by Jens Andrae on 2020-10-27
 */
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    // Two Way Object - Get's generated by MapStruct -> Compile and take a look in target... web.mappers

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
