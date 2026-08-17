package com.Business.Service.impl;

import com.Business.Domain.StoreStatus;
import com.Business.Execptions.UserException;
import com.Business.Mapper.StoreMapper;
import com.Business.Model.Store;
import com.Business.Model.StoreContact;
import com.Business.Model.User;
import com.Business.PayLoad.Dto.StoreDTO;
import com.Business.Repository.StoreRepository;
import com.Business.Service.StoreService;
import com.Business.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public StoreDTO getStoreById(Long id) throws Exception {
        Store store = storeRepository.findById(id).orElseThrow(
                () -> new Exception("STORE NOT FOUND.....")
        );
        return StoreMapper.toDTO(store);
    }

    @Override
    public List<StoreDTO> getAllStore() {
        return List.of();
    }

    @Override
    public List<StoreDTO> getAllStore(StoreDTO storeDTO, User user) {
        List<Store> dtos = storeRepository.findAll();
        return dtos.stream().map(StoreMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Store getStoreByAdmin() throws UserException {
        User admin = userService.getCurrentUser();
        return storeRepository.findByStoreAdminId(admin.getId());
    }

    @Override
    public StoreDTO updateStore(Long id, StoreDTO storeDTO) throws Exception {
        User currenUser = userService.getCurrentUser();

        Store existing = storeRepository.findByStoreAdminId(currenUser.getId());

        if (existing == null) {
            throw new Exception("Store not Found ");
        }
        existing.setBrand(storeDTO.getBrand());
        existing.setDescription(storeDTO.getDescription());

        if (storeDTO.getStoreType()!=null) {
            existing.setStoreType(storeDTO.getStoreType());
        }
        if(storeDTO.getContact()!=null){
            StoreContact contact = StoreContact.builder()
                    .address(storeDTO.getContact().getAddress())
                    .phone(storeDTO.getContact().getPhone())
                    .email(storeDTO.getContact().getEmail())
                    .build();
            existing.setContact(contact);
        }
        Store updatedStore = storeRepository.save(existing);
        return StoreMapper.toDTO(updatedStore);
    }

    @Override
    public void deleteStore(Long id) throws UserException {
        Store store = getStoreByAdmin();
        storeRepository.delete(store);
    }

    @Override
    public StoreDTO getStoreByEmployee() throws UserException {
        User currentUser = userService.getCurrentUser();
        if (currentUser == null) {
            throw new UserException("you don't have permission to access this store  ");
        }
        return StoreMapper.toDTO(currentUser.getStore());
    }

    @Override
    public StoreDTO moderateStore(Long id, StoreStatus Status) throws Exception {
        Store store =storeRepository.findById(id).orElseThrow(
                ()->new Exception("Store Not Found .....")
        );
        store.setStatus(Status);
        Store updatedStore = storeRepository.save(store);
        return StoreMapper.toDTO(updatedStore);
    }
}

// Day 28 audit checkpoint A