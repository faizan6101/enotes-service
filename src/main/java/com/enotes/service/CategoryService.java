package com.enotes.service;

import java.util.List;

import com.enotes.AppResponse.CategoryResponse;
import com.enotes.dto.CategoryDto;
import com.enotes.entity.Category;

public interface CategoryService {

    //save category
	public CategoryDto saveCategory(CategoryDto category);

    //get all categories
	public List<CategoryDto>getAllCategory();

    //List of aactive categories
    List<CategoryResponse>getActiveCategory();

    //get category by Id
    public CategoryDto getCategoryById(Long id);

    //delete category
//   public void deleteCategoryById(Long id);
}
