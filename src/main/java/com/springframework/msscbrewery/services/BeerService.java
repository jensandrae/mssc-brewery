package com.springframework.msscbrewery.services;

import com.springframework.msscbrewery.web.model.BeerDto;
import java.util.UUID;

/**
 * Created by Jens Andrae on 2020-10-15
 */
public interface BeerService {

    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);
}
