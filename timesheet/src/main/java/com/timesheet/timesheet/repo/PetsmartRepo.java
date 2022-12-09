package com.timesheet.timesheet.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.timesheet.timesheet.entity.PetsmartSheet;

/**
 * @author opera_ao6omsd PetsmartRepo.
 *
 */
@EnableJpaRepositories
@Repository
public interface PetsmartRepo extends JpaRepository<PetsmartSheet, String>{

//
////    @Query("SELECT Name FROM PetsmartSheet")
////    List<PetsmartRepo> findByname();
////    
////    @Query(value = "SELECT name FROM PetsmartSheet", nativeQuery = true)
////    public List<Object[]> findEmp_name();
//    
//    @Query(value = "SELECT * FROM PETSMART_SHEET where name='prakriti gupta'", nativeQuery = true)
//    public List<PetsmartSheet> findByname();
}
