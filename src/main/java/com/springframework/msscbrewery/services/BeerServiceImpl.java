package com.springframework.msscbrewery.services;

import com.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;
import java.util.UUID;

/**
 * Created by Jens Andrae on 2020-10-15
 */
@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        // ToDo: Implement - Would add a real impl to update beer
    }
}
