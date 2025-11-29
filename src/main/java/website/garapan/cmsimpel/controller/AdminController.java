package website.garapan.cmsimpel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import website.garapan.cmsimpel.model.FormLandingPageContent;
import website.garapan.cmsimpel.service.LandingPageService;

@Controller
public class AdminController {

    @Autowired
    private LandingPageService landingPageService;

    @GetMapping("/admin")
    public String adminDashboard(Model model) {
        FormLandingPageContent formContent = landingPageService.convertToFormContent(landingPageService.getLandingPageContent());
        model.addAttribute("content", formContent);
        return "admin/dashboard";
    }

    @PostMapping("/admin/save")
    public String saveLandingPageContent(FormLandingPageContent content) {
        landingPageService.updateLandingPageContent(content);
        return "redirect:/admin?success";
    }
}