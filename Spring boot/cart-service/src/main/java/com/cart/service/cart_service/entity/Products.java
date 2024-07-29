package com.cart.service.cart_service.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false, updatable = false)
    private Integer productId;

    @Column(name = "description", length = 1200, nullable = false)
    private String description;

    @Column(name = "image_url", length = 1000, nullable = false)
    private String imageUrl;

    @Column(name = "title", length = 500, nullable = false)
    private String title;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    private String productOwnerName;

}
