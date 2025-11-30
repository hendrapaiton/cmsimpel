package website.garapan.cmsimpel.model;

import java.util.List;
import java.util.Map;

public class LandingPageContent {

    // Hero Section
    private String heroTitle;
    private String heroSubtitle;
    private String heroButtonText1;
    private String heroButtonLink1;
    private String heroButtonText2;
    private String heroButtonLink2;
    private String heroImage;

    // Stats Section
    private List<Map<String, String>> stats;

    // About Section
    private String aboutTitle;
    private String aboutSubtitle;
    private String aboutDescription;
    private String aboutImageUrl;

    // Services Section
    private List<Map<String, String>> services;

    // Portfolio Section
    private List<Map<String, String>> portfolio;

    // Team Section
    private List<Map<String, String>> team;

    // Testimonials Section
    private List<Map<String, String>> testimonials;

    // FAQ Section
    private List<Map<String, String>> faqs;

    // Contact Section
    private Map<String, String> contactInfo;

    // Site Info
    private String siteTitle;
    private String siteName;
    private String siteDescription;
    private String logoPath;

    // Tech Stack Section
    private List<String> techStack;

    // Getters
    public String getHeroTitle() {
        return heroTitle;
    }

    public String getHeroSubtitle() {
        return heroSubtitle;
    }

    public String getHeroButtonText1() {
        return heroButtonText1;
    }

    public String getHeroButtonLink1() {
        return heroButtonLink1;
    }

    public String getHeroButtonText2() {
        return heroButtonText2;
    }

    public String getHeroButtonLink2() {
        return heroButtonLink2;
    }

    public String getHeroImage() {
        return heroImage;
    }

    public List<Map<String, String>> getStats() {
        return stats;
    }

    public String getAboutTitle() {
        return aboutTitle;
    }

    public String getAboutSubtitle() {
        return aboutSubtitle;
    }

    public String getAboutDescription() {
        return aboutDescription;
    }

    public String getAboutImageUrl() {
        return aboutImageUrl;
    }

    public List<Map<String, String>> getServices() {
        return services;
    }

    public List<Map<String, String>> getPortfolio() {
        return portfolio;
    }

    public List<Map<String, String>> getTeam() {
        return team;
    }

    public List<Map<String, String>> getTestimonials() {
        return testimonials;
    }

    public List<Map<String, String>> getFaqs() {
        return faqs;
    }

    public Map<String, String> getContactInfo() {
        return contactInfo;
    }

    public String getSiteTitle() {
        return siteTitle;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getSiteDescription() {
        return siteDescription;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public List<String> getTechStack() {
        return techStack;
    }

    // Setters
    public void setHeroTitle(String heroTitle) {
        this.heroTitle = heroTitle;
    }

    public void setHeroSubtitle(String heroSubtitle) {
        this.heroSubtitle = heroSubtitle;
    }

    public void setHeroButtonText1(String heroButtonText1) {
        this.heroButtonText1 = heroButtonText1;
    }

    public void setHeroButtonLink1(String heroButtonLink1) {
        this.heroButtonLink1 = heroButtonLink1;
    }

    public void setHeroButtonText2(String heroButtonText2) {
        this.heroButtonText2 = heroButtonText2;
    }

    public void setHeroButtonLink2(String heroButtonLink2) {
        this.heroButtonLink2 = heroButtonLink2;
    }

    public void setHeroImage(String heroImage) {
        this.heroImage = heroImage;
    }

    public void setStats(List<Map<String, String>> stats) {
        this.stats = stats;
    }

    public void setAboutTitle(String aboutTitle) {
        this.aboutTitle = aboutTitle;
    }

    public void setAboutSubtitle(String aboutSubtitle) {
        this.aboutSubtitle = aboutSubtitle;
    }

    public void setAboutDescription(String aboutDescription) {
        this.aboutDescription = aboutDescription;
    }

    public void setAboutImageUrl(String aboutImageUrl) {
        this.aboutImageUrl = aboutImageUrl;
    }

    public void setServices(List<Map<String, String>> services) {
        this.services = services;
    }

    public void setPortfolio(List<Map<String, String>> portfolio) {
        this.portfolio = portfolio;
    }

    public void setTeam(List<Map<String, String>> team) {
        this.team = team;
    }

    public void setTestimonials(List<Map<String, String>> testimonials) {
        this.testimonials = testimonials;
    }

    public void setFaqs(List<Map<String, String>> faqs) {
        this.faqs = faqs;
    }

    public void setContactInfo(Map<String, String> contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setSiteTitle(String siteTitle) {
        this.siteTitle = siteTitle;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public void setSiteDescription(String siteDescription) {
        this.siteDescription = siteDescription;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public void setTechStack(List<String> techStack) {
        this.techStack = techStack;
    }
}