package com.product.catalog.controller;


import com.product.catalog.entity.db.Rating;
import com.product.catalog.service.db.rating.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping(params = "productId")
    public ResponseEntity<List<Rating>> getRatingsByProductId(@RequestParam("productId") Integer productId) {
        return new ResponseEntity<>(ratingService.getProductRatingsByProductId(productId), HttpStatus.OK);
    }

    @GetMapping(params = "ratingId")
    public ResponseEntity<Rating> getRatingById(@RequestParam("ratingId") Integer ratingId) {
        return new ResponseEntity<>(ratingService.getRatingByRatingId(ratingId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        return new ResponseEntity<>(ratingService.createRating(rating), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Rating> updateRating(@RequestBody Rating rating, @RequestParam Integer ratingId) {
        return new ResponseEntity<>(ratingService.updateRating(ratingId, rating), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteRatingById(@RequestParam Integer ratingId) {
        return new ResponseEntity<>(ratingService.deleteRating(ratingId), HttpStatus.OK);
    }

}
