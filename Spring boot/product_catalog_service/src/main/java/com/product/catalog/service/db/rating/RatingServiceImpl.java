package com.product.catalog.service.db.rating;

import com.product.catalog.dao.rating.RatingDao;
import com.product.catalog.entity.db.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingDao ratingDao;

    public RatingServiceImpl(RatingDao ratingDao) {
        this.ratingDao = ratingDao;
    }

    @Override
    public List<Rating> getProductRatingsByProductId(Integer productId) {
        return ratingDao.getProductRatingsByProductId(productId);
    }

    @Override
    public Rating getRatingByRatingId(Integer ratingId) {
        return ratingDao.getRatingByRatingId(ratingId);
    }

    @Override
    public Rating createRating(Rating rating) {
        return ratingDao.createRating(rating);
    }

    @Override
    public Rating updateRating(Integer ratingId, Rating rating) {
        return ratingDao.updateRating(ratingId,rating);
    }

    @Override
    public String deleteRating(Integer ratingId) {
        return ratingDao.deleteRating(ratingId);
    }
}
