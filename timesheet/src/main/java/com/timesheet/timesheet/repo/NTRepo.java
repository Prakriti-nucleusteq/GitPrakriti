package com.timesheet.timesheet.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timesheet.timesheet.entity.NTSheet;

/**
 * @author opera_ao6omsd NTRepo.
 *
 */
@Repository
public interface NTRepo extends JpaRepository<NTSheet, String>{
//
//    @Query(value = "SELECT * FROM NTSHEET where email='pg@gmail.com'", nativeQuery = true)
//    public List<NTSheet> findByname();
}
