package com.project.helpesk.services;

import com.project.helpesk.dto.AddCategoryResponseDto;
import com.project.helpesk.dto.CategoryInDto;
import com.project.helpesk.exceptions.PreExistingCategoryException;

/**
 * @author opera_ao6omsd
 *
 */
public interface CategoryServiceNew {
    /**
     * @param categoryInDto category In dto.
     * @return get all categories and subcategories.
     * @throws PreExistingCategoryException throws exception.
     */
    AddCategoryResponseDto saveCategoryAndSubcategory(CategoryInDto categoryInDto) throws PreExistingCategoryException;
    /**
     * @return get all categories and subcategories.
     */

}
