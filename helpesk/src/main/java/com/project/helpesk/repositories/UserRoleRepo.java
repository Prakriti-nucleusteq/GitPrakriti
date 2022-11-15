package com.project.helpesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.project.helpesk.entities.UserRole;

/**
 * @author opera_ao6omsd repository.
 *
 */
public interface UserRoleRepo extends JpaRepository<UserRole, Integer> {

    /**
     * @param userId userid.
     * @return find by id.
     */
    @Query("SELECT u FROM UserRole u WHERE u.userId = :userId")
    UserRole findById(@Param("userId") int userId);

}
