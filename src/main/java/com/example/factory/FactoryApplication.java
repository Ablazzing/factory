package com.example.factory;

import com.example.factory.entity.Employee;
import com.example.factory.entity.EmployeePosition;
import com.example.factory.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class FactoryApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FactoryApplication.class, args);
		//Бин для работы с БД
		EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);

		//Создание сотрудника как java объекта
		Employee employeeSergey = Employee.builder()
				.name("Sergey")
				.age(29)
				.employeePosition(EmployeePosition.BOSS)
				.build();
		//Сохранение сотрудника в БД
		employeeRepository.save(employeeSergey);

		//Создадим еще одного работника
		Employee employeeYuri = Employee.builder()
				.name("Yuri")
				.age(32)
				.build();
		employeeRepository.save(employeeYuri);


		//Поиск всех сотрудников из таблицы
		List<Employee> employees = employeeRepository.findAll();
		//Поиск сотрудников по имени
		List<Employee> employeesWithNameYuri = employeeRepository.findName("Yuri");

		//Удалим сотрудника Сергея
		employeeRepository.delete(employeeSergey);

		//Поставим должность Юрию
		employeeYuri.setEmployeePosition(EmployeePosition.MANAGER);
		//Обновим данные по Юрию
		employeeRepository.save(employeeYuri);
	}
}
