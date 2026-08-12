package com.Business.Service;

import com.Business.Model.User;
import com.Business.PayLoad.Dto.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO, User user) throws Exception;
    ProductDTO updateProduct(Long id ,ProductDTO productDTO, User user) throws Exception;
    void deleteProduct(Long Id , User user) throws Exception;
    List<ProductDTO> getProductByStoreId(Long StoreId );

    List<ProductDTO>  searchByKeywords(Long storeId , String keywords);




}
