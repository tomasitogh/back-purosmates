package com.uade.tpo.E_commerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table( name = "orders" ) // Se le cambia el nombre a la tabla porque "order" es una palabra reservada en SQL
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column
    private long count;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false) // Nombre de la columna en la tabla orders que referencia a user
    private User user;
}
