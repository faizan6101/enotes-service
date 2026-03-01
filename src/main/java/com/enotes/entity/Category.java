package com.enotes.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "categories")
public class Category extends BaseModel{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "category_name")
	private String name;

    @Column(name = "category_description")
	private String description;


	
}
