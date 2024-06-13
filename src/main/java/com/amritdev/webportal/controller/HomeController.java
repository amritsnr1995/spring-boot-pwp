package com.amritdev.webportal.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.amritdev.webportal.entity.Home;
import com.amritdev.webportal.entity.PostMessage;
import com.amritdev.webportal.service.HomeService;

import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	private HomeService homeService;

	@GetMapping("/home")
	public String getHomePage(Model model) {
		List<Home> homes = homeService.getAllHomes();
		Home home = homes.isEmpty() ? new Home() : homes.get(0);
		List<PostMessage> postMessages = homeService.getAllPostMessages();
		model.addAttribute("home", home);
		model.addAttribute("postMessages", postMessages);
		return "home";
	}

	@PostMapping("/postMessages")
	public String createPostMessage(PostMessage postMessage) {

		// Format the current date and time as a String
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = formatter.format(new Date());
		postMessage.setDatePosted(formattedDate); // Set the formatted date
		homeService.savePostMessage(postMessage);
		return "redirect:/home";
	}

	@GetMapping("/edit")
	public String editHomePage(Model model) {
		Home home = homeService.getHome();
		model.addAttribute("home", home);
		return "update"; // Return the update.html template
	}

	 @PostMapping("/update")
	    public String updateHome(@Valid Home home, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            model.addAttribute("home", home);
	            return "update"; // Return to the update page if validation errors occur
	        }
	        Home existingHome = homeService.getHome();
	        if (existingHome != null) {
	            existingHome.setMessage(home.getMessage());
	            existingHome.setQuote(home.getQuote());
	            homeService.saveHome(existingHome);
	        }
	        return "redirect:/home";
	    }
	 
	 

	   

}
