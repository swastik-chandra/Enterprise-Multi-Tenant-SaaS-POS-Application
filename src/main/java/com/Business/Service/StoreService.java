package com.Business.Service;

import com.Business.Domain.StoreStatus;
import com.Business.Execptions.UserException;
import com.Business.Model.Store;
import com.Business.Model.User;
import com.Business.PayLoad.Dto.StoreDTO;

import java.util.List;

public interface StoreService {

    StoreDTO createStore(StoreDTO StoreDTO, User user);
    StoreDTO getStoreById(Long id) throws Exception;
    List<StoreDTO> getAllStore();

    List<StoreDTO> getAllStore(StoreDTO storeDTO, User user);

    Store getStoreByAdmin() throws UserException;
    StoreDTO updateStore(Long id, StoreDTO storeDTO) throws Exception;
    void deleteStore(Long id) throws UserException;
    StoreDTO getStoreByEmployee() throws UserException;

    StoreDTO moderateStore(Long id , StoreStatus Status  )throws Exception;


}
