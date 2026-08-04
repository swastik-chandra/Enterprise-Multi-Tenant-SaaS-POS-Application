package com.Business.PayLoad.Dto;

import com.Business.Domain.StoreStatus;
import com.Business.Model.StoreContact;
import com.Business.Model.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StoreDTO {
        private Long id;
        private String brand;

        private UserDto storeAdmin;

        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        private String Description;
        private String storeType;

        private StoreStatus Status;
        private StoreContact contact ;
}
