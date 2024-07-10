package com.product.catalog.dao.rating;

import com.product.catalog.dao.product.ProductDao;
import com.product.catalog.entity.db.Products;
import com.product.catalog.entity.db.Rating;
import com.product.catalog.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingImplDao implements RatingDao {

    private final RatingRepository ratingRepository;
    private final ProductDao productDao;

    public RatingImplDao(RatingRepository ratingRepository, ProductDao projectDao) {
        this.ratingRepository = ratingRepository;
        this.productDao = projectDao;
    }

    @Override
    public List<Rating> getProductRatingsByProductId(Integer productId) {
        Products existsProduct = productDao.getProductsByProductId(productId);
        return ratingRepository.findByProduct(existsProduct);
    }
}
