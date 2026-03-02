package com.enotes.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "categories")
@EntityListeners(AuditingEntityListener.class)
public class Category extends BaseModel{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "name")
	private String name;

    @Column(name = "description")
	private String description;


    private Boolean isActive;

    private Boolean isDeleted;
	
}
