package com.amritdev.webportal.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.amritdev.webportal.entity.Biography;
import com.amritdev.webportal.entity.Education;
import com.amritdev.webportal.entity.Home;
import com.amritdev.webportal.entity.Personal;
import com.amritdev.webportal.repository.BiographyRepository;
import com.amritdev.webportal.repository.EducationRepository;
import com.amritdev.webportal.repository.HomeRepository;
import com.amritdev.webportal.repository.PersonalRepository;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private HomeRepository homeRepository;

    @Autowired
    private PersonalRepository personalRepository;

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private BiographyRepository biographyRepository;

    @Override
    public void run(String... args) throws Exception {
        // Check if the home table is empty, then add default data
        if (homeRepository.count() == 0) {
            Home home = new Home();
            home.setMessage("Welcome to my personal portfolio");
            home.setQuote("The only way to master coding is to build projects");
            homeRepository.save(home);
        }

        // Check if the personal table is empty, then add default data
        if (personalRepository.count() == 0) {
            Biography biography = null;
            Education education = null;

            // Check if the biography already exists, then add default data if not
            if (!biographyRepository.existsByFirstnameAndLastname("John", "Doe")) {
                biography = new Biography();
                biography.setFirstname("John");
                biography.setLastname("Doe");
                biography.setAge(30);
                // Convert Date to String
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                biography.setBirthdate(sdf.format(new Date()));
                biography.setLocation("Tokyo");
                biography.setCountry("Japan");
                biography.setHobbies(Arrays.asList("coding", "hacking"));
                biography.setReadings(Arrays.asList("technology", "fiction"));

                biographyRepository.save(biography);
            } else {
                // Fetch the existing biography
                biography = biographyRepository.findByFirstnameAndLastname("John", "Doe");
            }

            // Check if the education already exists, then add default data if not
            if (!educationRepository.existsByEduclevelAndInstitutionAndDegree("Bachelor's", "Kyoto University", "Computer Science")) {
                education = new Education();
                education.setEduclevel("Bachelor's");
                education.setInstitution("Kyoto University");
                education.setDegree("Computer Science");
                education.setSpecialization("Software Engineering");
                education.setYear("2018");

                educationRepository.save(education);
            } else {
                // Fetch the existing education
                education = educationRepository.findByEduclevelAndInstitutionAndDegree("Bachelor's", "Kyoto University", "Computer Science");
            }

            // Create and save personal only if both biography and education exist
            if (biography != null && education != null) {
                Personal personal = new Personal();
                personal.setBiography(biography);
                personal.setEducation(education);

                personalRepository.save(personal);
            }
        }
    }
}
