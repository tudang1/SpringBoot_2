package com.example.testjpa_1123.repository;

import com.example.testjpa_1123.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByEmailAddressEqualsAndLastNameLike(String emailAddress, String lastName);

    List<Employee> findByFirstNameLikeOrLastNameLike(String firstName, String lastName);

    List<Employee> findByLastNameLikeOrderByFirstNameAsc(String lastName);

    List<Employee> findByFirstNameIsIgnoreCase(String firstName);

    @Query(
            value = "SELECT * FROM Employee u WHERE u.status = 1",
            nativeQuery = true)
    Collection<Employee> findAllEmployee();


    List<Employee> fetchByLastName();
}