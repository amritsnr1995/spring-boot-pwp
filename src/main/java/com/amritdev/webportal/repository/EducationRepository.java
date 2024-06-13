package com.amritdev.webportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amritdev.webportal.entity.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
       boolean existsByEduclevelAndInstitutionAndDegree(String edulevel,String instituion,String degree);
       Education findByEduclevelAndInstitutionAndDegree(String educlevel, String institution, String degree);
}
