package com.springframework.msscbrewery.web.controller.v2;

import com.springframework.msscbrewery.services.v2.BeerServiceV2;
import com.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by Jens Andrae on 2020-10-18
 */
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    // Automatic Autowired cause there is a constructor with parameter BeerService beerService
    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping // POST - creates a new Resource
    public ResponseEntity handlePost(@RequestBody BeerDtoV2 beerDtoV2) {
        BeerDtoV2 savedDto = beerServiceV2.saveNewBeer(beerDtoV2);
        HttpHeaders headers = new HttpHeaders();
        // ToDo: Add hostname to url
        headers.add("Location", "/api/v1/beer" + savedDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId,@RequestBody BeerDtoV2 beerDtoV2) {
        beerServiceV2.updateBeer(beerId, beerDtoV2);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerServiceV2.deleteById(beerId);
    }
}
