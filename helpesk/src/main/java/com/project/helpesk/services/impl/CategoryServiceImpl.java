package com.project.helpesk.services.impl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.helpesk.dto.CategoryDto;
import com.project.helpesk.dto.SubCategoryDto;
import com.project.helpesk.entities.Category;
import com.project.helpesk.entities.Subcategory;

import com.project.helpesk.exceptions.ResourceNotFoundException;
import com.project.helpesk.repositories.CategoryRepo;
import com.project.helpesk.repositories.SubCategoryRepo;
import com.project.helpesk.services.CategoryService;

/**
 * @author opera_ao6omsd category.
 *
 */
@Service
public final class CategoryServiceImpl implements CategoryService {

    /**
     * category.
     */
    @Autowired
    private CategoryRepo categoryRepo;

    /**
     * subCategoryRepo.
     */
    @Autowired
    private SubCategoryRepo subCategoryRepo;

    /**
     * modelMapper.
     */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * createCategory.
     */
    /**
     * categoryDto.
     */
    @Override
    public CategoryDto createCategory(final CategoryDto categoryDto) {

        Category category = this.modelMapper.map(categoryDto, Category.class);

        Category addedCat = this.categoryRepo.save(category);

        return this.modelMapper.map(addedCat, CategoryDto.class);
    }

    /**
     * categoryDto.
     */
    @Override
    public CategoryDto updateCategory(final CategoryDto categoryDto, final Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));

        cat.setCategoryName(categoryDto.getCategoryName());
        System.out.print(categoryDto.getCategoryName());
        Category updatedcat = this.categoryRepo.save(cat);

        return this.modelMapper.map(updatedcat, CategoryDto.class);
    }

    /**
     * deletecategory.
     */
    @Override
    public void deleteCategory(final Integer categoryId) {

        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category id", categoryId));
        this.categoryRepo.delete(category);

    }

    /**
     * category.
     */
    @Override
    public CategoryDto getCategory(final Integer categoryId) {

        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category id", categoryId));

        return this.modelMapper.map(cat, CategoryDto.class);

    }

    /**
     * list categoryDto.
     */
    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = this.categoryRepo.findAll();

        List<CategoryDto> catDtos = categories.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class))
                .collect(Collectors.toList());

        return catDtos;
    }

    /**
     * subcategoryDto.
     */
    @Override
    public List<SubCategoryDto> getSubCategories() {
        List<Subcategory> subCategories = this.subCategoryRepo.findAll();

        List<SubCategoryDto> subCatDtos = subCategories.stream()
                .map((cat) -> this.modelMapper.map(cat, SubCategoryDto.class)).collect(Collectors.toList());

        return subCatDtos;
    }

    /**
     * SubCategoryDto.
     */
    @Override
    public List<SubCategoryDto> findById(final int categoryId) {
        List<Subcategory> subCategories = this.subCategoryRepo.findById(categoryId);

        List<SubCategoryDto> subCatDtos = subCategories.stream()
                .map((cat) -> this.modelMapper.map(cat, SubCategoryDto.class)).collect(Collectors.toList());

        return subCatDtos;
    }

    /**
     * findByTitle.
     */
    @Override
    public Integer findByTitle(final String categoryTitle) {

        Integer categories = this.categoryRepo.findByTitle(categoryTitle);
        System.out.print(categories);
        return categories;

    }

}
