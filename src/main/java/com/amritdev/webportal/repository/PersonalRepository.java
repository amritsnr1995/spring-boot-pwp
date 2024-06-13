package com.amritdev.webportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amritdev.webportal.entity.Personal;
@Repository
public interface PersonalRepository extends JpaRepository<Personal, Long>{

}
