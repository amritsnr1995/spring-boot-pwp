package com.amritdev.webportal.service;

import com.amritdev.webportal.entity.Personal;

public interface PersonalService {

	Personal savePersonals(Personal personal);

	Personal getPersonalById(Long id);
	
	Personal updatePersonal(Long id, Personal personal);

}
