//package com.project.helpesk.dto;


//import static org.junit.jupiter.api.Assertions.*;
//import java.util.HashSet;
//import java.util.Set;
//import org.junit.jupiter.api.Test;
//import com.project.helpesk.entities.Subcategory;
//
//class CategoryDtoTest {
//	@Test
//	void test() {
//		CategoryDto categorydto = new CategoryDto();
//		Integer Id = 1;
//		String categoryName = "categoryTitle";
//		Set<Subcategory> subcategories = new HashSet<>();
//		categorydto.setId(Id);
//		categorydto.setCategoryName(categoryName);
//		categorydto.setSubcategories(subcategories);
//		assertEquals(Id, categorydto.getId());
//		assertEquals(categoryName, categorydto.getCategoryName());
//		assertEquals(subcategories, categorydto.getSubcategories());
//	}
//
//	@Test
//	public void testtoString() {
//		Integer Id = 1;
//		String categoryName = "categoryTitle";
//		Set<Subcategory> subcategories = new HashSet<>();
//		CategoryDto categorydto = buildCategory(Id, categoryName, subcategories);
//		assertNotNull(categorydto.toString());
//		System.out.println(categorydto.toString());
//	}
//
//	@Test
//	public void testGettersAndSetters() {
//		CategoryDto categorydto = new CategoryDto();
//		assertNull(categorydto.getId());
//		Integer Id = 1;
//		categorydto.setId(Id);
//		assertEquals(Id, categorydto.getId());
//		Set<Subcategory> subcategories = new HashSet<>();
//		categorydto.setSubcategories(subcategories);
//		assertEquals(subcategories, categorydto.getSubcategories());
//		assertNull(categorydto.getCategoryName());
//		String categorytitle = "categorytitle";
//		categorydto.setCategoryName(categorytitle);
//		assertEquals(categorytitle, categorydto.getCategoryName());
//	}
//
//	@Test
//	public void testEqualsAndHashCode() {
//		CategoryDto categorydto = new CategoryDto();
//		Integer Id = 1;
//		String categoryName = "categoryTitle";
//		Set<Subcategory> subcategories = new HashSet<>();
//		CategoryDto category1 = buildCategory(Id, categoryName, subcategories);
//		CategoryDto category2 = buildCategory(Id, categoryName, subcategories);
//		assertEquals(category1, category1);
//		assertEquals(false, category1.equals(null));
//		assertEquals(false, category1.equals(categorydto));
//		System.out.println(category1.toString().hashCode());
//		System.out.println(category1.toString().hashCode());
//		assertEquals(category1.hashCode(), category2.hashCode());
//	}
//
//	private CategoryDto buildCategory(Integer Id, String categoryName, Set<Subcategory> subcategories) {
//		CategoryDto categorydto = new CategoryDto();
//		categorydto.setId(Id);
//		categorydto.setCategoryName(categoryName);
//		categorydto.setSubcategories(subcategories);
//		return categorydto;
//	}
//}