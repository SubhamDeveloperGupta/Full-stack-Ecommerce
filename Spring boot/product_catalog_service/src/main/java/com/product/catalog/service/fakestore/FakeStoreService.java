package com.product.catalog.service.fakestore;

import com.product.catalog.entity.fakestore.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FakeStoreService {

    @Autowired
    private WebClient webClient;

    public Flux<ProductDetails> getProductDetails() {
        return webClient.get()
                .uri("/products")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(ProductDetails.class);
    }

    public Mono<ProductDetails> getProductDetailsById(String productId) {
        return webClient.get()
                .uri("/products/{productId}", productId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, ClientResponse::createError)
                .onStatus(HttpStatusCode::is5xxServerError, ClientResponse::createError)
                .bodyToMono(ProductDetails.class);
    }

    public Flux<ProductDetails> getProductDetailsByLimit(Integer limit) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/products")
                        .queryParam("limit", limit)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, ClientResponse::createError)
                .onStatus(HttpStatusCode::is5xxServerError, ClientResponse::createError)
                .bodyToFlux(ProductDetails.class);
    }

    public Flux<String> getProductAllCategories() {
        return webClient.get()
                .uri("/products/categories")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, ClientResponse::createException)
                .onStatus(HttpStatusCode::is5xxServerError, ClientResponse::createError)
                .bodyToFlux(String.class);
    }

    public Flux<ProductDetails> getProductDetailsByCategory(String categoryType) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/products/category")
                        .pathSegment(categoryType)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, ClientResponse::createException)
                .onStatus(HttpStatusCode::is5xxServerError, ClientResponse::createError)
                .bodyToFlux(ProductDetails.class);
    }

}
