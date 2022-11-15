package com.project.helpesk.entities;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author opera_ao6omsd
 *
 */
@Entity
@Table(name = "subcategory")
public final class Subcategory {
    /**
     * sub id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer subId;
    /**
     * subcategoryName.
     */
    @Column(name = "subcategory_name")
    private String subcategoryName;
    /**
     * category id.
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * subcategory.
     */
    public Subcategory() {
    }

    /**
     * @param subId           subId.
     * @param subcategoryName subCategoryName.
     * @param categoryId      categoryId.
     */
    public Subcategory(final Integer subId, final String subcategoryName, final Integer categoryId) {
        super();
        this.subId = subId;
        this.subcategoryName = subcategoryName;
        this.categoryId = categoryId;
    }

    /**
     * @return sub id.
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
     * @return subCategoryName.
     */
    public String getSubcategoryName() {
        return subcategoryName;
    }

    /**
     * @param subcategoryName subcategoryName.
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
     * to string method.
     */
    @Override
    public String toString() {
        return "Subcategory [subId=" + subId + ", subcategoryName=" + subcategoryName + ", categoryId=" + categoryId
                + "]";
    }

    /**
     * hashCode set.
     */
    @Override
    public int hashCode() {
        return Objects.hash(categoryId, subId, subcategoryName);
    }

    /**
     * equals method.
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
        Subcategory other = (Subcategory) obj;
        return Objects.equals(categoryId, other.categoryId) && Objects.equals(subId, other.subId)
                && Objects.equals(subcategoryName, other.subcategoryName);
    }
}
