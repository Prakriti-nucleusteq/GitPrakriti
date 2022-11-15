package com.project.helpesk.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.helpesk.entities.User;

/**
 * @author opera_ao6omsd userRepo.
 *
 */
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
//   @Query("Select u from User u where u.username=:username and u.password=:password")
//    Optional<User> findByUsernameOrPassword(String username,String password);
    /**
     * @param email query for select user by email
     * @return valid user.
     */
    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);

}
