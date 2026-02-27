package com.enotes.controller;

import java.util.List;

import com.enotes.AppResponse.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enotes.dto.CategoryDto;
import com.enotes.entity.Category;
import com.enotes.service.CategoryService;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {
	
	
	
	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("save-category")
	public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto saveCategory = categoryService.saveCategory(categoryDto);

        if(saveCategory!=null) {
			return new ResponseEntity<CategoryDto>(saveCategory,HttpStatus.CREATED);
		}else {
		return new ResponseEntity<CategoryDto>(HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	}
	
	
	
	@GetMapping("/category")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		List<CategoryDto> allCategory = categoryService.getAllCategory();
		if(CollectionUtils.isEmpty(allCategory)) {
			return  ResponseEntity.noContent().build();
		}else {
		return new ResponseEntity<List<CategoryDto>>(allCategory,HttpStatus.OK);
	}	
	}

    @GetMapping("/active-category")
    public ResponseEntity<List<CategoryResponse>> getActiveCategory(){
        List<CategoryResponse> activeCategory = categoryService.getActiveCategory();
        if(CollectionUtils.isEmpty(activeCategory)) {
            return  ResponseEntity.noContent().build();
        }else {
            return new ResponseEntity<List<CategoryResponse>>(activeCategory,HttpStatus.OK);
        }
    }

}
