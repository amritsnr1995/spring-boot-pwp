package com.amritdev.webportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amritdev.webportal.entity.Biography;

@Repository
public interface BiographyRepository extends JpaRepository<Biography, Long> {
	boolean existsByFirstnameAndLastname(String firstName, String lastName);
	Biography findByFirstnameAndLastname(String firstname, String lastname);
}
