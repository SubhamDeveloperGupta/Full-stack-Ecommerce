package com.product.catalog.repository;

import com.product.catalog.entity.db.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
    List<Rating> findByProductProductId(Integer productId);
}
