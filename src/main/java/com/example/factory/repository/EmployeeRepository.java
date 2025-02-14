package com.example.factory.repository;

import com.example.factory.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Репозиторий для работы с entity Employee
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * Метод, реализация которого будет создана с помощью рефлексии
     * (на основании названия метода)
     */
    List<Employee> findAllByAge(Integer age);

    /**
     * Метод, реализация которого определяется запросом из аннотации @Query
     */
    @Query(nativeQuery = true, value = """
                select * 
                from employee 
                where name = :name
            """)
    List<Employee> findName(String name);

    @Query(nativeQuery = true, value = """
            select *
            from employee
            where employee_position is null
            """)
    List<Employee> findByPositionIsNull();
}
