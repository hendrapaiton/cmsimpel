package website.garapan.cmsimpel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import website.garapan.cmsimpel.model.LandingPageContent;
import website.garapan.cmsimpel.service.LandingPageService;

@Controller
public class IndexController {

    @Autowired
    private LandingPageService landingPageService;

    @GetMapping("/")
    public String index(Model model) {
        LandingPageContent content = landingPageService.getLandingPageContent();

        // Add basic message
        model.addAttribute("message", content.getSiteDescription());

        // Add site info
        model.addAttribute("siteTitle", content.getSiteTitle());
        model.addAttribute("siteName", content.getSiteName());

        // Add hero data
        model.addAttribute("heroTitle", content.getHeroTitle());
        model.addAttribute("heroSubtitle", content.getHeroSubtitle());
        model.addAttribute("heroButtonText1", content.getHeroButtonText1());
        model.addAttribute("heroButtonLink1", content.getHeroButtonLink1());
        model.addAttribute("heroButtonText2", content.getHeroButtonText2());
        model.addAttribute("heroButtonLink2", content.getHeroButtonLink2());
        model.addAttribute("heroImage", content.getHeroImage());

        // Add stats
        model.addAttribute("stats", content.getStats());

        // Add about data
        model.addAttribute("aboutTitle", content.getAboutTitle());
        model.addAttribute("aboutSubtitle", content.getAboutSubtitle());
        model.addAttribute("aboutDescription", content.getAboutDescription());
        model.addAttribute("aboutImageUrl", content.getAboutImageUrl());

        // Add services data
        model.addAttribute("services", content.getServices());

        // Add portfolio data
        model.addAttribute("portfolio", content.getPortfolio());

        // Add team data
        model.addAttribute("teamMembers", content.getTeam());

        // Add testimonials
        model.addAttribute("testimonials", content.getTestimonials());

        // Add faqs
        model.addAttribute("faqs", content.getFaqs());

        // Add contact info
        model.addAttribute("contactInfo", content.getContactInfo());

        return "index";
    }
}