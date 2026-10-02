package com.Business.Mapper;

import com.Business.Model.Category;
import com.Business.PayLoad.Dto.CategoryDTO;

public class CategoryMapper {
    public static CategoryDTO toDTO(Category category) {
       return CategoryDTO.builder()
               .name(category.getName())
               .storeId(category.getStore() != null ? category.getStore().getId() : null)
               .build();

    }
}
