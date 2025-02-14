package com.example.factory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Работник
 */
@Entity //Создает связь между таблицей в бд и java классом
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id //Помечает, что здесь содержится primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //отвечает за генерацию значений
    private Integer id;

    @Column //Помечает, что это значение существует как колонка в бд
    private String name;

    @Column
    private Integer age;

    @Enumerated(EnumType.STRING) //Преобразует значение Enum в String
    @Column
    private EmployeePosition employeePosition;
}
