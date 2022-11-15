package com.project.helpesk.dto;

import javax.persistence.Column;

/**
 * @author opera_ao6omsd
 *
 */

public final class SubCategoryDto {

    /**
     * sub id.
     */
    private Integer subId;
    /**
     * subcategory name.
     */
    @Column(name = "subcategory_name")
    private String subcategoryName;
    /**
     * category id.
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * @return get sub id.
     */
    public Integer getSubId() {
        return subId;
    }

    /**
     * @param subId sub id.
     */
    public void setSubId(final Integer subId) {
        this.subId = subId;
    }

    /**
     * @return subcategory name.
     */
    public String getSubcategoryName() {
        return subcategoryName;
    }

    /**
     * @param subcategoryName subcategory name.
     */
    public void setSubcategoryName(final String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    /**
     * @return category id.
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId category id.
     */
    public void setCategoryId(final Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * constructor subcategoryDto.
     */
    public SubCategoryDto() {

    }

}
