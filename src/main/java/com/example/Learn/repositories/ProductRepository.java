package com.example.Learn.repositories;

import com.example.Learn.dtos.ProductSummary;
import com.example.Learn.dtos.ProductSummaryDTO;
import com.example.Learn.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findProductsByName(String name);

    @Query(value = "SELECT * from products p where p.price between :min and :max", nativeQuery = true)
    List<Product> findProducts(@Param("min") int min, @Param("max") int max);

//    List<ProductSummary> getProductsByName(String name);


    @Query("SELECT new com.example.Learn.dtos.ProductSummaryDTO(p.name, p.price) FROM Product p WHERE p.name = :name")
    List<ProductSummaryDTO> getProductsByName(@Param("name") String name);

    @Query(value = "SELECT * FROM public.find_products_by_price(:minPrice, :maxPrice)", nativeQuery = true)
    List<Product> findProductsWithStoringProcedure(@Param("minPrice") BigDecimal minPrice,
                                                   @Param("maxPrice") BigDecimal maxPrice);

}
