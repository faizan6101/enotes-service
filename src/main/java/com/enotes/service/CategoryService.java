package com.enotes.service;

import java.util.List;

import com.enotes.AppResponse.CategoryResponse;
import com.enotes.dto.CategoryDto;
import com.enotes.entity.Category;

public interface CategoryService {

	public CategoryDto saveCategory(CategoryDto category);
	public List<CategoryDto>getAllCategory();

    List<CategoryResponse>getActiveCategory();
}
