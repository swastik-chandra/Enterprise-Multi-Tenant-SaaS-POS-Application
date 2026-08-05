package com.Business.Repository;

import com.Business.Model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Store findByStoreAdminId(Long adminId );
}
