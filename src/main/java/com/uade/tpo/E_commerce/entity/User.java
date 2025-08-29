package com.uade.tpo.E_commerce.entity;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private Role mail;

    @OneToMany(mappedBy="user") // se refiere a la clase user entera no solo al id
    private List<Order> orders;

    @ManyToMany
    @JoinTable(name="user_id", joinColumns= @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<Role> roles;
}
