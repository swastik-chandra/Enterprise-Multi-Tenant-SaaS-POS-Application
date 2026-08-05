package com.Business.PayLoad.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private String sku;
    private String description;
    private double mrp;
    private double sellingPrice;
}
