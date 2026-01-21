package com.example.Learn.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class ProductSummaryDTO {
    private String name;
    private BigDecimal price;
}
