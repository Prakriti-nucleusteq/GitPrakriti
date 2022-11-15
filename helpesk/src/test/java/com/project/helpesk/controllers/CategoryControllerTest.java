package com.project.helpesk.controllers;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.helpesk.dto.AddCategoryResponseDto;
import com.project.helpesk.dto.CategoryDto;
import com.project.helpesk.dto.CategoryInDto;
import com.project.helpesk.entities.Category;
import com.project.helpesk.entities.Subcategory;
import com.project.helpesk.exceptions.PreExistingCategoryException;
import com.project.helpesk.services.CategoryServiceNew;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {
    @InjectMocks
    private CategoryController categoryController;
    @Mock
    CategoryServiceNew categoryServiceNew;
    @Autowired
    private MockMvc mockMvc;
    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }
    @Test
    void saveCategoryAndSubcategory() throws Exception {
        MockitoAnnotations.openMocks(this);
        
//        Integer id = 6;
        String categoryName = "Hardware";
        Set<Subcategory> subcategories = new HashSet<>();
        Subcategory subcategoryInDto1 = new Subcategory(1, "Mouse", 1);
        subcategories.add(subcategoryInDto1);
        CategoryInDto categoryInDto = new CategoryInDto(categoryName, subcategories);
        
        Integer objId = 4;
        Boolean success = true;
        String message = "Creation successful";
        AddCategoryResponseDto responseDto = new AddCategoryResponseDto(objId, success, message);
        
        String inputJSON = new ObjectMapper().writeValueAsString(categoryInDto);
        when(categoryServiceNew.saveCategoryAndSubcategory(categoryInDto)).thenReturn(responseDto);
        MvcResult mvcResult = this.mockMvc
                .perform(post("/api/categories/create").contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        
        System.out.println("");
        AddCategoryResponseDto result = categoryServiceNew.saveCategoryAndSubcategory(categoryInDto);
        assertEquals(responseDto, result);
        assertNotEquals(false, result);
        System.out.println("result status>>>"+status);
        assertEquals(200, status);
        assertNotEquals(400, status);
        assertEquals(responseDto, categoryServiceNew.saveCategoryAndSubcategory(categoryInDto));
    }
}
//
//    @Test
//    void getAllCategoriesAndSubcategories() throws Exception {
//        MockitoAnnotations.openMocks(this);
//        Integer id = 6;
//        String categoryName = "Hardware";
//        Set<Subcategory> subcategories2 = new HashSet<>();
//        Subcategory subcategory3= new Subcategory(1, "Mouse", 1);
//        Subcategory subcategory4= new Subcategory(1, "Keyboard", 2);
//        subcategories2.add(subcategory3);
//        subcategories2.add(subcategory4);
//        Category category2 = new Category(id, categoryName, subcategories2);
////        List<CategoryInDto> cat = new ArrayList<CategoryInDto>();
////        cat.add(category2);
//        AddCategoryResponseDto responseDto = new AddCategoryResponseDto(objId, success, message);
//
//        String inputJSON = new ObjectMapper().writeValueAsString(categoryInDto);
//        when(categoryServiceNew.getAllCategoriesAndSubcategories()).thenReturn(responseDto);
//        MvcResult mvcResult = this.mockMvc
//                .perform(get("/admin/categoryorsubcategory").contentType(MediaType.APPLICATION_JSON).content(inputJSON))
//                .andReturn();
//        int status = mvcResult.getResponse().getStatus();
//        System.out.println("");
//        List<Category> result = categoryServiceNew.getAllCategoriesAndSubcategories();
//        assertEquals(responseDto, result);
//        assertNotEquals(false, result);
//        System.out.println(result);
//        assertEquals(200, status);
//        assertNotEquals(400, status);
//        assertEquals(responseDto, categoryServiceNew.getAllCategoriesAndSubcategories());
//    }
//}