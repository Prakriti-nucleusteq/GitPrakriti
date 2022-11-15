package com.project.helpesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.project.helpesk.dto.CategoryDto;
import com.project.helpesk.entities.Category;

/**
 * @author opera_ao6omsd category repo.
 *
 */
@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

    /**
     * @param categoryName category name.
     * @return find title.
     */
    @Query("SELECT c.objId FROM Category c WHERE c.categoryName = :categoryName")
    Integer findByTitle(@Param("categoryName") String categoryName);

    /**
     * @param objId objid.
     * @return find title.
     */
    @Query("SELECT c.categoryName FROM Category c WHERE c.objId = :objId")
    Category findTitle(@Param("objId") Integer objId);

}
