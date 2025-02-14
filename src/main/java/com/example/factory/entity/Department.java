package com.example.factory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Цех
 */
@Entity
@Table(name = "dep") //Позволяет указывать на какую конкретно таблицу ссылается entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dep_name", unique = true, length = 4096) //unique - создаст constraint unique
    private String name;

    @Column(nullable = false) //nullable = false - Создаст ограничение NOT NULL
    private String address;
}
