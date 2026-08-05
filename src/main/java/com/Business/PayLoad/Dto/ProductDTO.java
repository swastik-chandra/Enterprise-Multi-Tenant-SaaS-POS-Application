package com.Business.PayLoad.Dto;

import com.Business.Model.Store;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class ProductDTO {
    private Long id ;
    private String name;

    private String sku;


    private String description;

    private double mrp;

    private double sellingPrice;
    private String brand;
    private String image;

//    private Category category;

    private Long categoryId;

    private Long storeId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
