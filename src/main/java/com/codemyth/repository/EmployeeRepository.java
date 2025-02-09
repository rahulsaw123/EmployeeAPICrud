package com.codemyth.repository;

import com.codemyth.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


    public List<Employee> findByCity(String city);


    @Query("SELECT e FROM Employee e WHERE e.city = :city")
    List<Employee> findByCity1(@Param("city") String city);


}
