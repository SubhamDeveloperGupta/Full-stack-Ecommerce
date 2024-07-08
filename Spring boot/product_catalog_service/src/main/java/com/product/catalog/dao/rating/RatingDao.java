package com.product.catalog.dao.rating;

import com.product.catalog.entity.db.Rating;

import java.util.List;

public interface RatingDao {
    List<Rating> getProductRatingsByProductId(Integer productId);
}
