package com.amritdev.webportal.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amritdev.webportal.entity.Home;
import com.amritdev.webportal.entity.PostMessage;
import com.amritdev.webportal.repository.HomeRepository;
import com.amritdev.webportal.repository.PostMessageRepository;
import com.amritdev.webportal.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private HomeRepository homeRepository;

	@Autowired
	private PostMessageRepository postMessageRepository;

	@Override
	public List<Home> getAllHomes() {
		// TODO 自動生成されたメソッド・スタブ
		return homeRepository.findAll();
	}

	@Override
	public Home getHomeById(Long id) {
		// TODO 自動生成されたメソッド・スタブ
		return homeRepository.findById(id).orElse(null);
	}

	@Override
	public Home saveHome(Home home) {
		// TODO 自動生成されたメソッド・スタブ
		return homeRepository.save(home);
	}

	@Override
	public void deleteHome(Long id) {
		homeRepository.deleteById(id);

	}

	@Override
	public List<PostMessage> getAllPostMessages() {
		// TODO 自動生成されたメソッド・スタブ
		return postMessageRepository.findAll();
	}

	@Override
	public PostMessage savePostMessage(PostMessage postMessage) {
		// TODO 自動生成されたメソッド・スタブ
		return postMessageRepository.save(postMessage);
	}

	@Override
	public Home getHome() {
		
		return homeRepository.findAll().stream().findFirst().orElse(null);
	}

}
