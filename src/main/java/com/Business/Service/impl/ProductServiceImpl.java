package com.Business.Service.impl;
import com.Business.Repository.CategoryRepository;
import com.Business.Mapper.ProductMapper;
import com.Business.Model.Category;
import com.Business.Model.Product;
import com.Business.Model.Store;
import com.Business.Model.User;
import com.Business.PayLoad.Dto.ProductDTO;
import com.Business.Repository.ProductRepository;
import com.Business.Repository.StoreRepository;
import com.Business.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO, User user) throws Exception {
        Store store = storeRepository.findById(
                productDTO.getStoreId()
        ).orElseThrow(
                () -> new Exception("Store Not Found ")
        );
        Category category = categoryRepository.findById(
                productDTO.getCategoryId()
        ).orElseThrow(
                () -> new Exception("Category Not Found")
        );
        Product product = ProductMapper.toEntity(productDTO, store, category);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.toDTO(savedProduct);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO, User user) throws Exception { return null; }
    @Override
    public void deleteProduct(Long Id, User user) throws Exception {}
    @Override
    public List<ProductDTO> getProductByStoreId(Long StoreId) { return List.of(); }
    @Override
    public List<ProductDTO> searchByKeywords(Long storeId, String keywords) { return List.of(); }
}
