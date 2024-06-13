package com.amritdev.webportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Education {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Education level is required")
	private String educlevel;
	@NotBlank(message = "Institution is required")
	private String institution;
	@NotBlank(message = "Degree is required")
	private String degree;
	@NotBlank(message = "Specialization is required")
	private String specialization;
	@NotBlank(message = "Year is required")
	private String year;

}
