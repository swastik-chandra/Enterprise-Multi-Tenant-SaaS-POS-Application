package com.Business.Model;

import com.Business.Domain.StoreStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String brand;

    private String Description;
    private String storeType;

    private StoreStatus Status;
    @Embedded
    private StoreContact contact = new StoreContact();
}
