package com.example.api;

import com.example.entity.ProductEntity;
import com.example.entity.ReviewEntity;
import com.example.repository.ProductRepository;
import com.example.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    @GetMapping
    public ResponseEntity<?> getProducts() {
        Iterable<ProductEntity> products = productRepository.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping(value = "/{productId}/reviews")
    public ResponseEntity<?> getProductReviews(
            @PathVariable("productId") int productId
    ) {
        Iterable<ReviewEntity> reviews =reviewRepository.findByProductId(productId);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping(value = "/{productId}/reviews")
    public ResponseEntity<?> postProductReview(
            @PathVariable("productId") int productId,
            @RequestBody ReviewEntity reviewEntity
    ) {
        ProductEntity productEntity=new ProductEntity();
        productEntity.setId(productId);
        reviewEntity.setProduct(productEntity);
        reviewRepository.save(reviewEntity);
        reviewEntity=reviewRepository.save(reviewEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewEntity);
    }


}
