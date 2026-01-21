package com.example.Learn.services;

import com.example.Learn.dtos.ProductSummary;
import com.example.Learn.dtos.ProductSummaryDTO;
import com.example.Learn.entities.Category;
import com.example.Learn.entities.Product;
import com.example.Learn.repositories.CategoryRepository;
import com.example.Learn.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public void persistProductCategory() {
        var product = Product.builder()
                .name("criket")
                .price(BigDecimal.valueOf(800))
                .description("criket")
                .build();

        Category category = categoryRepository.findById(3).orElseThrow();

        product.addCategory(category);

        productRepository.save(product);
    }

    public void deleteProduct() {
        Product product = productRepository.findById(1).orElseThrow();
        productRepository.delete(product);
    }

    public List<ProductSummaryDTO> getProducts() {
        return productRepository.getProductsByName("criket");
    }
}
