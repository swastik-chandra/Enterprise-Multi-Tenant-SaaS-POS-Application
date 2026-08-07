package com.Business.Mapper;

import com.Business.Model.Store;
import com.Business.PayLoad.Dto.StoreDTO;

public class StoreMapper {

    public static StoreDTO toDTO(Store store) {
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(store.getId());
        storeDTO.setBrand(store.getBrand());
        storeDTO.setDescription(store.getDescription());
        storeDTO.setStoreType(store.getStoreType());
        storeDTO.setContact(store.getContact());
        storeDTO.setStatus(store.getStatus());
        storeDTO.setCreatedAt(store.getCreatedAt());
        storeDTO.setUpdatedAt(store.getUpdatedAt());

        if (store.getStoreAdmin() != null) {
            storeDTO.setStoreAdmin(
                    UserMapper.toDTO(store.getStoreAdmin())
            );
        }
        return storeDTO;
    }
}
