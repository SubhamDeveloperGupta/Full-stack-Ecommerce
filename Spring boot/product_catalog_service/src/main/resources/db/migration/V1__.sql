CREATE TABLE categories
(
    category_id INT AUTO_INCREMENT NOT NULL,
    name        VARCHAR(100) NOT NULL,
    CONSTRAINT pk_categories PRIMARY KEY (category_id)
);

CREATE TABLE products
(
    product_id    INT AUTO_INCREMENT NOT NULL,
    category_id   INT          NOT NULL,
    `description` VARCHAR(1200) NOT NULL,
    image_url     VARCHAR(1000) NOT NULL,
    title         VARCHAR(500) NOT NULL,
    price         DECIMAL      NOT NULL,
    CONSTRAINT pk_products PRIMARY KEY (product_id)
);

CREATE TABLE rating
(
    rating_id  INT AUTO_INCREMENT NOT NULL,
    rate       DECIMAL(2, 1) NOT NULL,
    product_id INT NULL,
    CONSTRAINT pk_rating PRIMARY KEY (rating_id)
);

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES categories (category_id);

ALTER TABLE rating
    ADD CONSTRAINT FK_RATING_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES products (product_id);