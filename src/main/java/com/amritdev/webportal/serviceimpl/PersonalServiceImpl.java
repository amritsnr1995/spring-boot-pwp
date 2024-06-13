package com.amritdev.webportal.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amritdev.webportal.entity.Personal;
import com.amritdev.webportal.repository.PersonalRepository;
import com.amritdev.webportal.service.PersonalService;

@Service
public class PersonalServiceImpl implements PersonalService {
	@Autowired
	PersonalRepository personalRepository;

	@Override
	public Personal savePersonals(Personal personal) {
		return personalRepository.save(personal);
	}

	@Override
	public Personal getPersonalById(Long id) {
		return personalRepository.findById(id).orElseThrow(() -> new RuntimeException("Personal not found"));
	}

	@Override
	public Personal updatePersonal(Long id, Personal personal) {
		Personal existingPersonal = personalRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Personal not found"));

		boolean isUpdated = false;

		if (personal.getBiography() != null && !existingPersonal.getBiography().equals(personal.getBiography())) {
			System.out.println(
					"Biography updated from " + existingPersonal.getBiography() + " to " + personal.getBiography());
			existingPersonal.setBiography(personal.getBiography());
			isUpdated = true;
		}

		// If more fields need to be checked, add similar checks here

		if (isUpdated) {
			return personalRepository.save(existingPersonal);
		} else {
			return existingPersonal;
		}
	}
}
