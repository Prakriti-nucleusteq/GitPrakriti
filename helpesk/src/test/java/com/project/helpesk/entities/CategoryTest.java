package com.project.helpesk.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class CategoryTest {

   @Test
    public void category1Test() {
       Integer objId = 1;
       String categoryName = "hardware";
       
       Integer subId =1;
       String subcategoryName= "hardware";
       Integer categoryId= 12;
       
       Subcategory Subcategory = new Subcategory(subId,subcategoryName, categoryId );
       Set<Subcategory> subcatList = new HashSet<Subcategory>();
       subcatList.add(Subcategory);
       Category category= new Category();
       category.setObjId(objId);
       category.setCategoryName(subcategoryName);
       category.setSubcategories(subcatList);
       
        assertEquals(objId, category.getObjId());
        assertEquals(categoryName, category.getCategoryName());
        assertEquals(subcatList, category.getSubcategories());
        
        Category category2= new Category( objId,  categoryName,  subcatList);
        
   }
    
   @Test
   public void testHash() {
       Category category= new Category();
       Integer objId = 1;
       String categoryName = "hardware";
       
       Integer subId =1;
       String subcategoryName= "hardware";
       Integer categoryId= 12;
       
       Subcategory Subcategory = new Subcategory(subId,subcategoryName, categoryId );
       Set<Subcategory> subcatList =new HashSet<Subcategory>();
       subcatList.add(Subcategory);
       category.setObjId(objId);
       category.setCategoryName(subcategoryName);
       category.setSubcategories(subcatList);
       Category category1= new Category( objId,  categoryName,  subcatList);
       Category category2= new Category( objId,  categoryName,  subcatList);
       
       assertEquals(category1.hashCode(), category2.hashCode());
    }
   
   @Test
   public void testToString() {
       Category category= new Category();
       Integer objId = 1;
       String categoryName = "hardware";
       
       Integer subId =1;
       String subcategoryName= "hardware";
       Integer categoryId= 12;
       
       Subcategory Subcategory = new Subcategory(subId,subcategoryName, categoryId );
       Set<Subcategory> subcatList =new HashSet<Subcategory>();
       subcatList.add(Subcategory);
       category.setObjId(objId);
       category.setCategoryName(subcategoryName);
       category.setSubcategories(subcatList);
       Category category1= new Category( objId,  categoryName,  subcatList);
       Category category2= new Category( objId,  categoryName,  subcatList);
       
       assertEquals(category1.toString(), category2.toString());
    }
   
   @Test
   public void testEqual() {
       Category category= new Category();
       Integer objId = 1;
       String categoryName = "hardware";
       
       Integer subId =1;
       String subcategoryName= "hardware";
       Integer categoryId= 12;
       
       Subcategory Subcategory = new Subcategory(subId,subcategoryName, categoryId );
       Set<Subcategory> subcatList =new HashSet<Subcategory>();
       subcatList.add(Subcategory);
       category.setObjId(objId);
       category.setCategoryName(subcategoryName);
       category.setSubcategories(subcatList);
       Category category1= new Category( objId,  categoryName,  subcatList);
       Category category2= new Category( objId,  categoryName,  subcatList);
       
       assertEquals(true, category1.equals(category1));
//       assertEquals(false, category1.equals(category2));
       assertEquals(true, category1.equals(category));

    }
   
}
