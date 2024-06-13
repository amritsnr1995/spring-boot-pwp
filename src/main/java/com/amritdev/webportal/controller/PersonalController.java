package com.amritdev.webportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.amritdev.webportal.entity.Personal;
import com.amritdev.webportal.service.PersonalService;

import jakarta.validation.Valid;

@Controller
public class PersonalController {
    @Autowired
    PersonalService personalService;

    @GetMapping("/personal")
    public String getPersonalPage(Model model) {
        Personal personal = personalService.getPersonalById(1L);
        model.addAttribute("personal", personal);
        return "personal";
    }

    @GetMapping("/personal/edit")
    public String editPersonalPage(Model model) {
        Personal personal = personalService.getPersonalById(1L);
        model.addAttribute("personal", personal);
        return "editPersonal";
    }

    @PostMapping("/personal/update")
    public String updatePersonal(@ModelAttribute @Valid Personal personal, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("personal", personal);
            return "editPersonal";
        }

        try {
        	// Check if the personal object has an ID
            if (personal.getId() != null) {
                Personal updatedPersonal = personalService.updatePersonal(personal.getId(), personal);
                model.addAttribute("personal", updatedPersonal);
            } else {
                model.addAttribute("error", "Invalid personal ID");
                return "editPersonal";
            }
        } catch (Exception e) {
            model.addAttribute("personal", personal);
            return "editPersonal";
        }
        return "redirect:/personal";
    }
}
