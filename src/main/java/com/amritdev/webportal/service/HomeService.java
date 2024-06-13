package com.amritdev.webportal.service;

import java.util.List;

import com.amritdev.webportal.entity.Home;
import com.amritdev.webportal.entity.PostMessage;

public interface HomeService {
	List<Home> getAllHomes();
	
	Home getHome();

	Home getHomeById(Long id);

	Home saveHome(Home home);

	void deleteHome(Long id);

	List<PostMessage> getAllPostMessages();

	PostMessage savePostMessage(PostMessage postMessage);

}
