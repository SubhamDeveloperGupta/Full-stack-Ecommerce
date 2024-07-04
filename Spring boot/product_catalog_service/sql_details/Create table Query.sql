
-- Create categories table
CREATE TABLE categories(
	category_id int primary key auto_increment,
    name varchar(100) not null
);

-- Create Products table
CREATE TABLE products(
	product_id int primary key auto_increment,
    category_id int not null,
    description varchar(500) not null,
    image_url varchar(500) not null,
    title varchar(500) not null,
    price decimal not null,
    FOREIGN KEY(category_id) references category(category_id)
);

-- Create Rating table
CREATE TABLE rating(
	rating_id int primary key auto_increment,
    rate decimal(1,1) check(rate <= 5.0) not null,
    product_id int default null,
    FOREIGN KEY(product_id) references products(product_id)
);




