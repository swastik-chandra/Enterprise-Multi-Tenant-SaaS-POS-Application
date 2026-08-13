package com.Business.Service.impl;

import com.Business.Domain.StoreStatus;
import com.Business.Execptions.UserException;
import com.Business.Mapper.StoreMapper;
import com.Business.Model.Store;
import com.Business.Model.User;
import com.Business.PayLoad.Dto.StoreDTO;
import com.Business.Repository.StoreRepository;
import com.Business.Service.StoreService;
import com.Business.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final UserService userService;
    private final StoreRepository storeRepository;

    @Override
    public StoreDTO createStore(StoreDTO storeDTO, User user) {
        Store store = StoreMapper.toEntity(storeDTO, user);
        return StoreMapper.toDTO(storeRepository.save(store));
    }

    @Override
    public StoreDTO getStoreById(Long id) throws Exception { return null; }
    @Override
    public List<StoreDTO> getAllStore() { return List.of(); }
    @Override
    public List<StoreDTO> getAllStore(StoreDTO storeDTO, User user) { return List.of(); }
    @Override
    public Store getStoreByAdmin() throws UserException { return null; }
    @Override
    public StoreDTO updateStore(Long id, StoreDTO storeDTO) throws Exception { return null; }
    @Override
    public void deleteStore(Long id) throws UserException {}
    @Override
    public StoreDTO getStoreByEmployee() throws UserException { return null; }
    @Override
    public StoreDTO moderateStore(Long id, StoreStatus Status) throws Exception { return null; }
}
