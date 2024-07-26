package com.product.catalog.entity.db;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.product.catalog.dto.ProductDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@NamedNativeQuery(
        name = "Products.getProducts",
        query = "SELECT  " +
                " p.product_id AS productId, " +
                " c.name AS categoryName, " +
                " p.description AS description,  " +
                " p.image_url AS imageUrl, " +
                " p.title AS title,  " +
                " p.price AS price, " +
                " p.product_owner_name AS productOwnerName " +
                " FROM products p " +
                " JOIN categories c ON p.category_id = c.category_id",
        resultSetMapping = "Mapping.getProducts"
)
@SqlResultSetMapping(
        name = "Mapping.getProducts",
        classes = @ConstructorResult(targetClass = ProductDto.class,
            columns = {
                    @ColumnResult(name = "productId", type = Integer.class),
                    @ColumnResult(name = "categoryName", type = String.class),
                    @ColumnResult(name = "description", type = String.class),
                    @ColumnResult(name = "imageUrl", type = String.class),
                    @ColumnResult(name = "title", type = String.class),
                    @ColumnResult(name = "price", type = Double.class),
                    @ColumnResult(name = "productOwnerName", type = String.class),
            }
        )
)
@NamedNativeQuery(
        name = "Products.findProductById",
        query = "SELECT  " +
                " p.product_id AS productId, " +
                " c.name AS categoryName, " +
                " p.description AS description,  " +
                " p.image_url AS imageUrl, " +
                " p.title AS title,  " +
                " p.price AS price, " +
                " p.product_owner_name AS productOwnerName " +
                " FROM products p " +
                " JOIN categories c ON p.category_id = c.category_id " +
                " AND p.product_id = :productId",
        resultSetMapping = "Mapping.findProductById"
)
@SqlResultSetMapping(
        name = "Mapping.findProductById",
        classes = @ConstructorResult(targetClass = ProductDto.class,
            columns = {
                    @ColumnResult(name = "productId", type = Integer.class),
                    @ColumnResult(name = "categoryName", type = String.class),
                    @ColumnResult(name = "description", type = String.class),
                    @ColumnResult(name = "imageUrl", type = String.class),
                    @ColumnResult(name = "title", type = String.class),
                    @ColumnResult(name = "price", type = Double.class),
                    @ColumnResult(name = "productOwnerName", type = String.class),
            }
        )
)
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

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference
    private Category category;

    @Column(name = "description", length = 1200, nullable = false)
    private String description;

    @Column(name = "image_url", length = 1000, nullable = false)
    private String imageUrl;

    @Column(name = "title", length = 500, nullable = false)
    private String title;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonManagedReference
    private Set<Rating> ratings;

    private String productOwnerName;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Products products = (Products) o;
        return getProductId() != null && Objects.equals(getProductId(), products.getProductId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
