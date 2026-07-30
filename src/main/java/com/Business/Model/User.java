package com.Business.Model;

import com.Business.Domain.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    @Email(message = "Email should be valid ")
    private String email;

    private String phone;

    @ManyToOne
    private Store store;

    @Column(nullable = false)
    private UserRole role;
    @Column(nullable = false)
    private String password;
}
