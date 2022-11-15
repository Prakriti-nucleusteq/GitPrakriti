package com.project.helpesk.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.helpesk.dto.AddCategoryResponseDto;
import com.project.helpesk.dto.ApiResponse;
import com.project.helpesk.dto.CategoryDto;
import com.project.helpesk.dto.CategoryInDto;
import com.project.helpesk.dto.SubCategoryDto;
import com.project.helpesk.exceptions.PreExistingCategoryException;
import com.project.helpesk.services.CategoryService;
import com.project.helpesk.services.CategoryServiceNew;

/**
 * @author opera_ao6omsd
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/categories")
public final class CategoryController {

    /**
     * logger.
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * category service.
     */
    @Autowired
    private CategoryService categoryService;

    /**
     * category service new.
     */
    @Autowired
    private CategoryServiceNew categoryServiceNew;

    /**
     * @param categoryInDto categoryInDto.
     * @return add category.
     * @throws PreExistingCategoryException preExisting Catgory Exception.
     */
    @PostMapping("/create")
    public ResponseEntity<AddCategoryResponseDto> saveCategoryAndSubcategory(

            @RequestBody final CategoryInDto categoryInDto) throws PreExistingCategoryException {
        AddCategoryResponseDto result = categoryServiceNew.saveCategoryAndSubcategory(categoryInDto);
        logger.info("/api/categories/create");
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // delete

    /**
     * @param categoryId categoryId.
     * @return api response.
     */
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable final Integer categoryId) {

        this.categoryService.deleteCategory(categoryId);
        logger.info("/api/categories/{categoryId}");
        return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!", true),
                HttpStatus.OK);
    }
    // get

    /**
     * @param categoryId categoryId.
     * @return category dto.
     */
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable final Integer categoryId) {

        CategoryDto categoryDto = this.categoryService.getCategory(categoryId);
        logger.info("/api/categories/{categoryId}");
        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
    }

    // get

    /**
     * @return list of catoryDto
     */
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories() {

        List<CategoryDto> categories = this.categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }

    /**
     * @return list of subcategory dto.
     */
    @GetMapping("/subcategories")
    public ResponseEntity<List<SubCategoryDto>> getSubCategories() {

        List<SubCategoryDto> subCategories = this.categoryService.getSubCategories();
        return ResponseEntity.ok(subCategories);
    }

    /**
     * @param categoryId category id.
     * @return category service.
     */
    @GetMapping("/subcategories/{categoryId}")
    public List<SubCategoryDto> getSubCategoriesByCategory(@PathVariable final int categoryId) {

        return this.categoryService.findById(categoryId);

    }

    /**
     * @param categoryTitle category title.
     * @return category title by title.
     */
    @GetMapping("/categories/{categoryTitle}")
    public Integer getCategoryIdByCategoryTitle(@PathVariable final String categoryTitle) {

        return this.categoryService.findByTitle(categoryTitle);

    }

}
