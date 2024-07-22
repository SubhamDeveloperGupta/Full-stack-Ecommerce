package com.product.catalog.dao.rating;

import com.product.catalog.dao.product.ProductDao;
import com.product.catalog.entity.db.Rating;
import com.product.catalog.exception.ProductNotFoundException;
import com.product.catalog.exception.RatingNotFoundException;
import com.product.catalog.repository.RatingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RatingImplDao implements RatingDao {

    private final RatingRepository ratingRepository;
    private final ProductDao productDao;

    public RatingImplDao(RatingRepository ratingRepository, ProductDao projectDao) {
        this.ratingRepository = ratingRepository;
        this.productDao = projectDao;
    }

    @Override
    public List<Rating> getProductRatingsByProductId(Integer productId) {
        if(!productDao.existsProductByProductId(productId)) {
            throw new ProductNotFoundException("Product with id " + productId + " does not exist");
        }

        return ratingRepository.findByProductProductId(productId);
    }

    @Override
    public Rating getRatingByRatingId(Integer ratingId) {
        return ratingRepository.findById(ratingId)
                .orElseThrow(() -> new RatingNotFoundException("Cannot find rating with id " + ratingId));
    }

    @Override
    public Rating createRating(Rating rating) {
        if (rating.getProduct() == null || rating.getProduct().getProductId() == null) {
            throw new RatingNotFoundException("Cannot create rating with null product");
        }
        if (!productDao.existsProductByProductId(rating.getProduct().getProductId())) {
            throw new RatingNotFoundException("Cannot create rating with null product");
        }

        return ratingRepository.save(rating);
    }

    @Override
    public Rating updateRating(Integer ratingId, Rating rating) {

        if (!productDao.existsProductByProductId(rating.getProduct().getProductId())) {
            throw new RatingNotFoundException("Cannot create rating with null product");
        }

        Rating ratingObj = getRatingByRatingId(ratingId);

        if (rating.getProduct() == null ||
                rating.getProduct().getProductId() == null ||
                !rating.getProduct().getProductId().equals(ratingObj.getProduct().getProductId())) {
            throw new RatingNotFoundException("Cannot create rating with null product");
        }

        return ratingRepository.save(rating);
    }

    @Override
    public String deleteRating(Integer ratingId) {
        if(!ratingRepository.existsById(ratingId)) {
            throw new RatingNotFoundException("Cannot find rating with id " + ratingId);
        }
        ratingRepository.deleteById(ratingId);

        return "Rating delete successfully ratingId : "+ratingId;
    }

}
