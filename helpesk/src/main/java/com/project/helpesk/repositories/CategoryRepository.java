package com.project.helpesk.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.helpesk.dto.CategoryInDto;
import com.project.helpesk.entities.Category;

/**
 * @author opera_ao6omsd ndl.
 *
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    /**
     * @param categoryInDto category dto.
     * @return save all category.
     */
    CategoryInDto save(CategoryInDto categoryInDto);

    /**
     * @param categoryName categoryName.
     * @return findCategor By Category name.
     */
    Optional<Category> findCategoryByCategoryName(String categoryName);
}
