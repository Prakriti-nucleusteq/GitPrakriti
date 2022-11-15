package com.project.helpesk.services.impl;

import java.util.HashSet;
//import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.helpesk.dto.AddCategoryResponseDto;
import com.project.helpesk.dto.CategoryInDto;
import com.project.helpesk.entities.Category;
import com.project.helpesk.entities.Subcategory;
import com.project.helpesk.exceptions.PreExistingCategoryException;
import com.project.helpesk.repositories.CategoryRepository;
import com.project.helpesk.repositories.SubcategoryRepository;

import com.project.helpesk.services.CategoryServiceNew;

/**
 * @author bv.
 *
 */
@Service
public final class CategoryServiceImplNew implements CategoryServiceNew {
    /**
     * model mapper.
     */
    private ModelMapper map = new ModelMapper();
    /**
     * category repository.
     */
    @Autowired
    private CategoryRepository categoryRepository;
    /**
     * subcategory Repo.
     */
    @Autowired
    private SubcategoryRepository subcategoryRepository;

    /**
     * category.
     */
    @Override
    public AddCategoryResponseDto saveCategoryAndSubcategory(final CategoryInDto categoryInDto)
            throws PreExistingCategoryException {
        Set<Subcategory> subcategories = new HashSet<>();
        Optional<Category> optionalCategory = categoryRepository
                .findCategoryByCategoryName(categoryInDto.getCategoryName());
        if (optionalCategory.isPresent()) {
            throw new PreExistingCategoryException("A category by this name already exists");
        }
        Category category = map.map(categoryInDto, Category.class);
        Category cat = categoryRepository.save(category);
        category.getSubcategories().stream().map(c -> {
            c.setCategoryId(cat.getObjId());
            return c;
        }).collect(Collectors.toSet());
        subcategories.addAll(category.getSubcategories());
        subcategoryRepository.saveAll(subcategories);
        AddCategoryResponseDto addCategoryResponseDto = new AddCategoryResponseDto();
        addCategoryResponseDto.setObjId(category.getObjId());
        addCategoryResponseDto.setSuccess(true);
        addCategoryResponseDto.setMessage("Category/subcategory added");
        return addCategoryResponseDto;
    }

}
