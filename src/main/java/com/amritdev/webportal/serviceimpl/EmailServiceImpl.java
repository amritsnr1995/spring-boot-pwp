package com.amritdev.webportal.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.amritdev.webportal.entity.Email;
import com.amritdev.webportal.repository.EmailRepository;
import com.amritdev.webportal.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	private EmailRepository emailRepository;
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public Email saveEmail(Email email) {
		sendEmail(email);
		return emailRepository.save(email);
	}

	public void sendEmail(Email email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(email.getSendFrom());
		List<String> receipents = email.getSendTo();
		message.setTo(receipents.toArray(new String[0]));
		message.setSubject(email.getSubject());
		message.setText(email.getMessage());
		mailSender.send(message);
	}

}
