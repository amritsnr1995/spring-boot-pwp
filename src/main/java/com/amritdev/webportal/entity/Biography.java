package com.amritdev.webportal.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Biography {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "First name is required")
	private String firstname;
	@NotBlank(message = "Last name is required")
	private String lastname;
	@NotNull(message = "Age is required")
	private int age;
	@NotBlank(message = "Birthdate is required")
	private String birthdate;
	@NotBlank(message = "Location is required")
	private String location;
	@NotBlank(message = "country is required")
	private String country;
	@ElementCollection
	private List<String> hobbies;
	@ElementCollection
	private List<String> readings;

}
