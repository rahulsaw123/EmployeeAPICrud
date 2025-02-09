package com.codemyth.controller;

import com.codemyth.model.Employee;
import com.codemyth.service.EmployeeService;
import com.codemyth.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @GetMapping("/getEmployee")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> emp = employeeService.getAllEmployee();

        return ResponseEntity.ok(emp);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee emp = employeeService.addEmployee(employee);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id) {

        Optional<Employee> emp = employeeService.getEmployeeBYId(id);

        if (emp.isPresent()) {
            return new ResponseEntity<>(emp.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeBYId(id);

        if (employee.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        employeeService.deleteBYId(id);
        return ResponseEntity.noContent().build();

    }
//Delete the data

    @DeleteMapping("/deleteAll")

    public ResponseEntity<Void> deleteAllEmployees() {
        employeeService.deleteAll();
        return ResponseEntity.noContent().build();
    }

//gte the data from city
    @GetMapping("/City/{city}")
    public ResponseEntity<List<Employee>> findCity(@PathVariable String city){
        List<Employee> ci=employeeService.findByCity(city);

        if(ci.isEmpty()){
            return  ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(ci);
    }
}
