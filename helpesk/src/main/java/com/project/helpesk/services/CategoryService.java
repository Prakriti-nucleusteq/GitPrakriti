package com.project.helpesk.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.helpesk.dto.CategoryDto;
import com.project.helpesk.dto.SubCategoryDto;

/**
 * @author opera_ao6omsd category service.
 *
 */
@Service
public interface CategoryService {
    /**
     * @param categoryDto Create category
     * @return create the category
     */
    CategoryDto createCategory(CategoryDto categoryDto);

    /**
     * @param categoryDto category dto
     * @param categoryId  category id
     * @return update the category
     */
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    /**
     * @param categoryId delete category
     */
    void deleteCategory(Integer categoryId);

    /**
     * @param categoryId get the id
     * @return all the category
     */
    CategoryDto getCategory(Integer categoryId);

    /**
     * @return get cargories
     */
    List<CategoryDto> getCategories();

    /**
     * @return list of sub category.
     */
    List<SubCategoryDto> getSubCategories();

    /**
     * @param categoryTitle category title.
     * @return find by title.
     */
    Integer findByTitle(String categoryTitle);

    /**
     * @param categoryId category id.
     * @return list of subcategory.
     */
    List<SubCategoryDto> findById(int categoryId);

}
