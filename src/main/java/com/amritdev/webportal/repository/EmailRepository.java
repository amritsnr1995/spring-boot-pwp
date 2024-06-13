package com.amritdev.webportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amritdev.webportal.entity.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

}
