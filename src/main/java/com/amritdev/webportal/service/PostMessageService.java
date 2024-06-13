package com.amritdev.webportal.service;

import java.util.List;

import com.amritdev.webportal.entity.PostMessage;

public interface PostMessageService {
	PostMessage save(PostMessage postMessage);

	PostMessage findById(Long id);

	List<PostMessage> findAll();

	void deleteById(Long id);

}
