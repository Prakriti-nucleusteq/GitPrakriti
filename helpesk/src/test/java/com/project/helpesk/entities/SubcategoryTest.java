package com.project.helpesk.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
class SubcategoryTest {

    Integer subId = 1;
    String subcategoryName = "abc";
    Integer categoryId = 1;
    
    @Test
    public void testGetterSetter() {
        Subcategory subcategory= new Subcategory(subId, subcategoryName, categoryId);
        subcategory.setSubId(subId);
        subcategory.setSubcategoryName(subcategoryName);
        subcategory.setCategoryId(categoryId);
        
        assertEquals(1, subcategory.getSubId());
        assertEquals(subcategoryName, subcategory.getSubcategoryName());
        assertEquals(1, subcategory.getCategoryId());

    }
    @Test
  public void testEqualsAndHashCode() {
        Integer subId = 1;
        String subcategoryName = "abc";
        Integer categoryId = 1;
         
        Subcategory subcategory1= new Subcategory(subId, subcategoryName, categoryId);
        subcategory1.setSubId(subId);
        subcategory1.setSubcategoryName(subcategoryName);
        subcategory1.setCategoryId(categoryId);
       
        Subcategory subcategory2= new Subcategory(subId, subcategoryName, categoryId);
        subcategory2.setSubId(subId);
        subcategory2.setSubcategoryName(subcategoryName);
        subcategory2.setCategoryId(categoryId);
         

    }


}
