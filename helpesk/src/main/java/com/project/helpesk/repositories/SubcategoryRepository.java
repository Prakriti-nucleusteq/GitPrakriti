package com.project.helpesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.helpesk.entities.Subcategory;

/**
 * @author opera_ao6omsd repository.
 *
 */
@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Integer> {

}
