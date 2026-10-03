package com.Business.Mapper;

import com.Business.Model.Category;
import com.Business.Model.Product;
import com.Business.Model.Store;
import com.Business.PayLoad.Dto.ProductDTO;

public class ProductMapper {
    public static ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .sku(product.getSku())
                .description(product.getDescription())
                .mrp(product.getMrp())
                .sellingPrice(product.getSellingPrice())
                .brand(product.getBrand())
                .category(
                        CategoryMapper.toDTO(product.getCategory())
                )
                .categoryId(
                        product.getCategory() != null
                                ? product.getCategory().getId()
                                : null
                )
                .storeId(
                        product.getStore() != null
                                ? product.getStore().getId()
                                : null
                )
                .image(product.getImage())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }

    public static Product toEntity(ProductDTO productDTO,
                                   Store store,
                                   Category category) {
        return Product.builder()
                .name(productDTO.getName())
                .store(store)
                .category(category)
                .sku(productDTO.getSku())
                .description(productDTO.getDescription())
                .mrp(productDTO.getMrp())
                .brand(productDTO.getBrand())
                .sellingPrice(productDTO.getSellingPrice())
                .build();
    }
}
