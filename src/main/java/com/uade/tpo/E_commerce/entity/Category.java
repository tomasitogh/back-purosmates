package com.uade.tpo.E_commerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data //Define todos los getters y setters
// @Builder Patron que permite construir objetos dentro del repo
@Entity // Define que es una entidad de base de datos
public class Category {
    public Category() {}
    public Category(String description) {
        this.description = description;
    }
    @Id // Define la llave primaria
    @GeneratedValue(strategy=GenerationType.IDENTITY) // Define que el valor es autogenerado 
    private long id;

    @Column // Define que es una columna de la tabla
    private String description;
}
