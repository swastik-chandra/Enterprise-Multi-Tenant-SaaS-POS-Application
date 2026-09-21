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

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
    public ProductDTO updateProduct(Long id, ProductDTO productDTO, User user) throws Exception {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new Exception("product is not found ")
        );

        Category category = categoryRepository.findById(
                productDTO.getCategoryId()
        ).orElseThrow(
                () -> new Exception("Category Not Found")
        );


        product.setName(productDTO.getName());
        product.setDescription(product.getDescription());
        product.setSku(product.getSku());
        product.setImage(product.getImage());
        product.setMrp(product.getMrp());
        product.setSellingPrice(product.getSellingPrice());
        product.setBrand(product.getBrand());
        product.setUpdatedAt(LocalDateTime.now());
        Product savedProduct = productRepository.save(product);
        return null;
    }

    @Override
    public void deleteProduct(Long id, User user) throws Exception {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new Exception("Product is not found ")
        );
        productRepository.delete(product);

    }

    @Override
    public List<ProductDTO> getProductByStoreId(Long storeId) {

        List<Product> products = productRepository.findByStoreId(storeId);
        return products.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> searchByKeywords(Long storeId, String keywords) {
        List<Product> products = productRepository.searchByKeyword(storeId, keywords);
        return products.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }
}

// Day 63 audit checkpoint A