package com.cart.service.cart_service.service;

import com.cart.service.cart_service.dao.CartDetailsDao;
import com.cart.service.cart_service.entity.CartDetails;
import com.cart.service.cart_service.entity.Product;
import com.cart.service.cart_service.exceptions.GlobalException;
import com.cart.service.cart_service.exceptions.UserNotFoundException;
import com.cart.service.cart_service.util.CartRequest;
import com.cart.service.cart_service.util.ProductPair;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartDetailsServiceImpl implements CartDetailsService {

    private final CartDetailsDao cartDetailsDao;

    public CartDetailsServiceImpl(CartDetailsDao cartDetailsDao) {
        this.cartDetailsDao = cartDetailsDao;
    }

    @Override
    public List<CartDetails> getAllCart() {
        return cartDetailsDao.getAllCart();
    }

    @Override
    public CartDetails getAllCartsProductByUserId(Integer userId) {
        return cartDetailsDao.getAllCartsProductByUserId(userId);
    }

    @Override
    public CartDetails createCart(CartRequest request) {
        Integer userId = request.getUserId();
        Product product = request.getProduct();
        if (userId == null || product == null || product.getProductId() == null) {
            throw new GlobalException("UserId and product can't be null");
        }
        CartDetails cartObj = null;
        if (cartDetailsDao.existsByUserId(userId)) {
            cartObj = getAllCartsProductByUserId(userId);
        }

        if(cartObj == null) {
            cartObj = new CartDetails();
            cartObj.setUserId(userId);

            Map<Integer, ProductPair> productsMap = new HashMap<>();
            productsMap.put(product.getProductId(), new ProductPair(product, 1));

            cartObj.setProductsMap(productsMap);
        } else {
            Map<Integer, ProductPair> productsMap = cartObj.getProductsMap();
            if (productsMap.containsKey(product.getProductId())) {
                ProductPair productPair = productsMap.get(product.getProductId());
                productPair.setCount(productPair.getCount() + 1);
            } else {
                productsMap.put(product.getProductId(), new ProductPair(product, 1));
            }
        }
        return cartDetailsDao.createCart(cartObj);
    }

    @Override
    public CartDetails addNewItemToCart(Integer userId, Product product) {
        if(userId == null || product == null) {
            throw new GlobalException("UserId and product can't be null");
        }

        if(!cartDetailsDao.existsByUserId(userId)) {
            throw new UserNotFoundException();
        }
        CartDetails cartObj = getAllCartsProductByUserId(userId);

        Map<Integer, ProductPair> productsMap = cartObj.getProductsMap();

        if(productsMap.containsKey(product.getProductId())) {
            ProductPair productPair = productsMap.get(product.getProductId());
            productPair.setCount(productPair.getCount() + 1);
        } else {
            throw new GlobalException("Product not found");
        }

        return cartDetailsDao.addNewItemToCart(cartObj);
    }

    @Override
    public CartDetails decreaseProduct(Integer userId, Product product) {
        if(userId == null || product == null) {
            throw new GlobalException("UserId and product can't be null");
        }

        if(!cartDetailsDao.existsByUserId(userId)) {
            throw new UserNotFoundException();
        }

        CartDetails cartObj = getAllCartsProductByUserId(userId);

        Map<Integer, ProductPair> productsMap = cartObj.getProductsMap();

        if(productsMap.containsKey(product.getProductId()) &&
                productsMap.get(product.getProductId()).getCount() > 1) {
            ProductPair productPair = productsMap.get(product.getProductId());
            productPair.setCount(productPair.getCount() - 1);
        } else {
            throw new GlobalException("Product not found");
        }

        return cartDetailsDao.decreaseProduct(cartObj);
    }
}
