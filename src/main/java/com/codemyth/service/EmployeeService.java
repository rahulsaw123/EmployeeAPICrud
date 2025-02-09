package com.codemyth.service;

import com.codemyth.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService
{

Employee addEmployee(Employee employee);
Optional<Employee> getEmployeeBYId(Long id);
void deleteBYId(Long id);
List<Employee> getAllEmployee();
void deleteAll();
List<Employee> findByCity(String city);


}
