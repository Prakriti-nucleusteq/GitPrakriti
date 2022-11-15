package com.project.helpesk.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import javax.persistence.Transient;

import com.project.helpesk.entities.Subcategory;

/**
 * @author opera_ao6omsd
 *
 */

public final class CategoryDto {

    /**
     * integer id.
     */
    private Integer id;

    /**
     * category name of string type.
     */
    @Column(name = "category_name", unique = true)
    private String categoryName;

    /**
     * subcategories.
     */
    @Transient
    private Set<Subcategory> subcategories = new HashSet<>();

    /**
     * @return get id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param iid iid.
     */
    public void setId(final Integer iid) {
        id = iid;
    }

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
     * category dto.
     */
    public CategoryDto() {
    }

    /**
     * @param id            id.
     * @param categoryName  category name.
     * @param subcategories subcategories.
     */
    public CategoryDto(final Integer id, final String categoryName, final Set<Subcategory> subcategories) {
        super();
        this.id = id;
        this.categoryName = categoryName;
        this.subcategories = subcategories;
    }

}
