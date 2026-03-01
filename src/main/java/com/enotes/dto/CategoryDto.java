package com.enotes.dto;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
    
    private Long id;

	private String name;
	
	private String description;
	
	private Boolean isActive;
	
	private Boolean isDeleted;
	
	private Integer createdBy;
	
	private Date createdOn;
	
	private Integer updatedBy;
	
	private Date updatedOn;

}
