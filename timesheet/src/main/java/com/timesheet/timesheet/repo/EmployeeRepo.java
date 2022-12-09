package com.timesheet.timesheet.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timesheet.timesheet.entity.Employee;


/**
 * @author opera_ao6omsd EmployeeRepo.
 *
 */
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String>{
    
//    @Query("SELECT name FROM Employee")
//    List<Employee> findByname();
//    
//    @Query(value = "SELECT name,email FROM Employee where name=' prakriti gupta'", nativeQuery = true)
//    public List<Employee> findByname();
//    
//   

}
