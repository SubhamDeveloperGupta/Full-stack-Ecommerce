package com.product.catalog.service.db.rating;

import com.product.catalog.entity.db.Rating;

import java.util.List;

public interface RatingService {

    List<Rating> getProductRatingsByProductId(Integer productId);
    Rating getRatingByRatingId(Integer ratingId);
    Rating createRating(Rating rating);
    Rating updateRating(Integer ratingId, Rating rating);
    String deleteRating(Integer ratingId);

}
