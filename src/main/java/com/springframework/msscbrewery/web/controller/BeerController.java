package com.springframework.msscbrewery.web.controller;

import com.springframework.msscbrewery.services.BeerService;
import com.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

/**
 * Created by Jens Andrae on 2020-10-15
 */
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    // Automatic Autowired cause there is a constructor with parameter BeerService beerService
    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping // POST - creates a new Resource
    public ResponseEntity handlePost(@RequestBody BeerDto beerDto) {
        BeerDto savedDto = beerService.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        // ToDo: Add hostname to url
        headers.add("Location", "/api/v1/beer" + savedDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId,@RequestBody BeerDto beerDto) {
        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerService.deleteById(beerId);
    }
}