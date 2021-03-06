package com.springframework.msscbrewery.web.controller.v2;

import com.springframework.msscbrewery.services.v2.BeerServiceV2;
import com.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/{beerId}") // GET - a existing resource
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping // CREATE - a new resource
    public ResponseEntity handlePost(@Valid @RequestBody BeerDtoV2 beerDtoV2) {
        BeerDtoV2 savedDto = beerServiceV2.saveNewBeer(beerDtoV2);
        HttpHeaders headers = new HttpHeaders();
        // ToDo: Add hostname to url
        headers.add("Location", "/api/v2/beer" + savedDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}") // UPDATED - a existing resource
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDtoV2 beerDtoV2) {
        beerServiceV2.updateBeer(beerId, beerDtoV2);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}") // DELETE - a existing resource
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerServiceV2.deleteById(beerId);
    }
}