package com.amritdev.webportal.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amritdev.webportal.entity.PostMessage;
import com.amritdev.webportal.repository.PostMessageRespository;
import com.amritdev.webportal.service.PostMessageService;

@Service
public class PostMessageServiceImpl implements PostMessageService{
	@Autowired
	private PostMessageRespository postMessageRespository;

	@Override
	public PostMessage save(PostMessage postMessage) {
		return postMessageRespository.save(postMessage);
	}

	@Override
	public PostMessage findById(Long id) {
		 return postMessageRespository.findById(id).orElse(null);
	}

	@Override
	public List<PostMessage> findAll() {
		return postMessageRespository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		postMessageRespository.deleteById(id);
		
	}

}
