package com.codemyth.service;

import com.codemyth.model.Employee;
import com.codemyth.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
       return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeBYId(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void deleteBYId(Long id) {

        employeeRepository.deleteById(id);

    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();

    }

    @Override
    public List<Employee> findByCity(String city) {
   //     return employeeRepository.findByCity1(city);

        List<Employee> employeeList=employeeRepository.findAll();
        List<Employee> empByCity=employeeList.stream().filter(x->x.getCity().equals(city)).collect(Collectors.toList());


        return empByCity;

    }




}
