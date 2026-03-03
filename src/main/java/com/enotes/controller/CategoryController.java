package com.enotes.controller;

import java.util.List;

import com.enotes.AppResponse.CategoryResponse;
import com.enotes.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import com.enotes.dto.CategoryDto;
import com.enotes.service.CategoryService;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {
	
	
	
	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("save-category")
	public ResponseEntity<?> saveCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto saveCategory = categoryService.saveCategory(categoryDto);

        if(saveCategory!=null) {
			return CommonUtil.createBuildResponseMessage(categoryDto,"saved success",HttpStatus.CREATED);
            //return new ResponseEntity<CategoryDto>(saveCategory,HttpStatus.CREATED);
		}else {
	//	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            return CommonUtil.createErrorResponseMessage("Category Not saved",HttpStatus.INTERNAL_SERVER_ERROR);
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
        if(ObjectUtils.isEmpty(activeCategory)) {
            return  ResponseEntity.noContent().build();
        }else {
            return new ResponseEntity<List<CategoryResponse>>(activeCategory,HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryId(@PathVariable Long id){
        CategoryDto categoryById = categoryService.getCategoryById(id);
            return new ResponseEntity<>(categoryById,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoryId(@PathVariable Long id){
         categoryService.deleteCategoryById(id);
            return new ResponseEntity<>("category with id"+id +" deleted successfully" ,HttpStatus.OK);
        }


}
