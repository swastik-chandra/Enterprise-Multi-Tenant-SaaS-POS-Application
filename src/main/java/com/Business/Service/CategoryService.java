package com.Business.Service;

import com.Business.Execptions.UserException;
import com.Business.PayLoad.Dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO dto) throws Exception;
    List<CategoryDTO> getCategoryByStore(Long storeId);
    CategoryDTO updateCategory(Long id ,CategoryDTO dto) throws Exception;
    void deleteCategory(Long id ) throws Exception;


}
