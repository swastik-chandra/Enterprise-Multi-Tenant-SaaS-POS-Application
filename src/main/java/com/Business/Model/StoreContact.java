package com.Business.Model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class StoreContact {
    private String address;
    private String phone;
}
