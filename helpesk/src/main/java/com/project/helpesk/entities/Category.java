package com.project.helpesk.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author opera_ao6omsd
 *
 */
@Entity
@Table(name = "category")
public final class Category {
    /**
     * obj id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer objId;
    /**
     * category name.
     */
    @Column(name = "category_name", unique = true)
    private String categoryName;
    /**
     * set subcategory.
     */
    @Transient
    private Set<Subcategory> subcategories = new HashSet<>();

    /**
     * @return objId.
     */
    public Integer getObjId() {
        return objId;
    }

    /**
     * @param objId objid.
     */
    public void setObjId(final Integer objId) {
        this.objId = objId;
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
     * to string method.
     */
    @Override
    public String toString() {
        return "Category [objId=" + objId + ", categoryName=" + categoryName + ", subcategories=" + subcategories + "]";
    }

    /**
     * category.
     */
    public Category() {
        super();

    }

    /**
     * @param objId         objid.
     * @param categoryName  category name.
     * @param subcategories subcategories.
     */
    public Category(final Integer objId, final String categoryName, final Set<Subcategory> subcategories) {
        super();
        this.objId = objId;
        this.categoryName = categoryName;
        this.subcategories = subcategories;
    }

    /**
     * hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(categoryName, objId, subcategories);
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
        Category other = (Category) obj;
        return Objects.equals(categoryName, other.categoryName) && Objects.equals(objId, other.objId)
                && Objects.equals(subcategories, other.subcategories);
    }
}
