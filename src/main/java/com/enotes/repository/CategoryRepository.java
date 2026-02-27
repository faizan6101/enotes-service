package com.enotes.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.enotes.entity.Category;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Long>{

    List<Category> findByIsActiveTrue();
}
