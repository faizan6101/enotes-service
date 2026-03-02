package com.enotes.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.enotes.AppResponse.CategoryResponse;
import com.enotes.exception.ResourceNotFoundException;
import com.enotes.util.Validation;
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

    @Autowired
    private Validation validation;


	@Override
	public CategoryDto saveCategory(CategoryDto categoryDto) {

        //Validation checking
        validation.categoryValidation(categoryDto);

        Category category = mapper.map(categoryDto, Category.class);
        if(ObjectUtils.isEmpty(category.getId())){
            category.setIsDeleted(false);
//            category.setCreatedBy(1);
            category.setCreatedOn(new Date());
        }else{
            updateCategory(category);
        }
		Category saveCategory = categoryRepo.save(category);
        CategoryDto savedCategoryDto = mapper.map(saveCategory, CategoryDto.class);

        if (ObjectUtils.isEmpty(saveCategory)) {
			return null;
		}
		return savedCategoryDto;
	}

    private void updateCategory(Category category){
        Optional<Category> findById = categoryRepo.findById(category.getId());
        if(findById.isPresent()){
            Category category1 = findById.get();
            category.setCreatedBy(category1.getCreatedBy());
            category.setCreatedOn(category1.getCreatedOn());
            category.setIsDeleted(category1.getIsDeleted());
//            category.setUpdatedBy(1);
//            category.setUpdatedOn(new Date());
        }
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

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", id));
        return mapper.map(category,CategoryDto.class);
    }

    @Override
    public void deleteCategoryById(Long id) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", id));
        categoryRepo.delete(category);
        Category category1=new Category();
        category1.setIsDeleted(true);
        categoryRepo.save(category1);
    }

}
