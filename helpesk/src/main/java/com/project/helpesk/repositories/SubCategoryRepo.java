package com.project.helpesk.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.helpesk.entities.Subcategory;

/**
 * @author opera_ao6omsd category repo.
 *
 */
@Repository
public interface SubCategoryRepo extends JpaRepository<Subcategory, Integer> {

    /**
     * @param categoryId category ID.
     * @return find by id.
     */
    @Query("SELECT u FROM Subcategory u WHERE u.categoryId = :categoryId")
    List<Subcategory> findById(@Param("categoryId") int categoryId);
}
