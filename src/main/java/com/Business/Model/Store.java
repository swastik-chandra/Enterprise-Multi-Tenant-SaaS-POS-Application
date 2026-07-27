package com.Business.Model;

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
}
