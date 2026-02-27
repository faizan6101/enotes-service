package com.enotes.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import com.enotes.AppResponse.CategoryResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.enotes.dto.CategoryDto;
import com.enotes.entity.Category;
import com.enotes.repository.CategoryRepository;
import com.enotes.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ModelMapper mapper; 

	@Override
	public CategoryDto saveCategory(CategoryDto categoryDto) {

//        Category category =new Category();
//        category.setName(categoryDto.getName());
//        category.setDescription(categoryDto.getDescription());
//        category.setIsActive(categoryDto.getIsActive());
            /*using model mapper for converting categoryDto to category object */
        Category category = mapper.map(categoryDto, Category.class);
		category.setIsDeleted(false);
		category.setCreatedBy(1);
		category.setCreatedOn(new Date());
		Category saveCategory = categoryRepo.save(category);
        CategoryDto savedCategoryDto = mapper.map(saveCategory, CategoryDto.class);

        if (ObjectUtils.isEmpty(saveCategory)) {
			return null;
		}
		return savedCategoryDto;
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categorires = categoryRepo.findAll();
        List<CategoryDto> categoryDtoList = categorires.stream().map(cat -> mapper.map(cat, CategoryDto.class)).toList();
        return categoryDtoList;
	}

    @Override
    public List<CategoryResponse> getActiveCategory() {

        List<Category> byIsActiveTrue = categoryRepo.findByIsActiveTrue();
        List<CategoryResponse> categoryDtoList = byIsActiveTrue.stream().map(cat -> mapper.map(cat, CategoryResponse.class)).toList();
        return categoryDtoList;

    }

}
