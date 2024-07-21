package com.product.catalog.dto;
import com.product.catalog.entity.db.Rating;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Integer productId;
    private String categoryName;
    private String description;
    private String imageUrl;
    private String title;
    private Double price;
    private String productOwnerName;

    private List<Rating> ratingList;

}
