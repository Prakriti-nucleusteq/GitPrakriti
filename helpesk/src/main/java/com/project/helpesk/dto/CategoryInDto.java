package com.project.helpesk.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import com.project.helpesk.entities.Subcategory;

/**
 * @author opera_ao6omsd
 *
 */
public final class CategoryInDto {
    /**
     * category name.
     */
    private String categoryName;
    /**
     * set subcatgory.
     */
    private Set<Subcategory> subcategories = new HashSet<>();

    /**
     * @return category name.
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName category name.
     */
    public void setCategoryName(final String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return subcategories.
     */
    public Set<Subcategory> getSubcategories() {
        return subcategories;
    }

    /**
     * @param subcategories subcategories.
     */
    public void setSubcategories(final Set<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

    /**
     * to string method.
     */
    @Override
    public String toString() {
        return "CategoryInDto [categoryName=" + categoryName + ", subcategories=" + subcategories + "]";
    }

    /**
     * @param categoryName  category name.
     * @param subcategories subcategories.
     */
    public CategoryInDto(final String categoryName, final Set<Subcategory> subcategories) {
        super();
        this.categoryName = categoryName;
        this.subcategories = subcategories;
    }

    /**
     * category in dto.
     */
    public CategoryInDto() {

    }

    /**
     * hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(categoryName, subcategories);
    }

    /**
     * boolean equals.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        CategoryInDto other = (CategoryInDto) obj;
        return Objects.equals(categoryName, other.categoryName) && Objects.equals(subcategories, other.subcategories);
    }
}
