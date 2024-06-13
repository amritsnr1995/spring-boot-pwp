package com.amritdev.webportal.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.amritdev.webportal.entity.Email;
import com.amritdev.webportal.service.EmailService;

@Controller
public class EmailController {
	@Autowired
	private EmailService emailService;

	@GetMapping("/contact")
	public String showContactForm(Model model) {
		model.addAttribute("email", new Email());
		return "contact";
	}

	@PostMapping("/contact")
	public String sendEmail(@ModelAttribute("email") Email email, Model model) {
		List<String> receipientList = Arrays.asList(email.getSendTo().get(0).split(",\\s*"));
		email.setSendTo(receipientList);
		emailService.saveEmail(email);
		model.addAttribute("message", "Email sent sucessfully");
		return "contact";
	}

}
