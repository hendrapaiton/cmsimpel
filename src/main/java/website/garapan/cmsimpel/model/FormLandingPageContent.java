package website.garapan.cmsimpel.model;

import java.util.List;

// This model is for form binding since the regular model uses Maps that are harder to bind
public class FormLandingPageContent {

    // Hero Section
    private String heroTitle;
    private String heroSubtitle;
    private String heroButtonText1;
    private String heroButtonLink1;
    private String heroButtonText2;
    private String heroButtonLink2;
    private String heroImage;

    // Stats Section - Using individual fields for form binding
    private List<StatItemForm> stats;

    // About Section
    private String aboutTitle;
    private String aboutSubtitle;
    private String aboutDescription;
    private String aboutImageUrl;

    // Services Section
    private List<ServiceItemForm> services;

    // Portfolio Section
    private List<PortfolioItemForm> portfolio;

    // Team Section
    private List<TeamItemForm> team;

    // Testimonials Section
    private List<TestimonialItemForm> testimonials;

    // FAQ Section
    private List<FaqItemForm> faqs;

    // Tech Stack Section
    private List<String> techStack;

    // Contact Section - Using individual fields
    private String contactAddress;
    private String contactEmail;
    private String contactPhone;

    // Site Info
    private String siteTitle;
    private String siteName;
    private String siteDescription;
    private String logoPath;

    // Main class getters and setters
    public String getHeroTitle() { return heroTitle; }
    public void setHeroTitle(String heroTitle) { this.heroTitle = heroTitle; }

    public String getHeroSubtitle() { return heroSubtitle; }
    public void setHeroSubtitle(String heroSubtitle) { this.heroSubtitle = heroSubtitle; }

    public String getHeroButtonText1() { return heroButtonText1; }
    public void setHeroButtonText1(String heroButtonText1) { this.heroButtonText1 = heroButtonText1; }

    public String getHeroButtonLink1() { return heroButtonLink1; }
    public void setHeroButtonLink1(String heroButtonLink1) { this.heroButtonLink1 = heroButtonLink1; }

    public String getHeroButtonText2() { return heroButtonText2; }
    public void setHeroButtonText2(String heroButtonText2) { this.heroButtonText2 = heroButtonText2; }

    public String getHeroButtonLink2() { return heroButtonLink2; }
    public void setHeroButtonLink2(String heroButtonLink2) { this.heroButtonLink2 = heroButtonLink2; }

    public String getHeroImage() { return heroImage; }
    public void setHeroImage(String heroImage) { this.heroImage = heroImage; }

    public List<StatItemForm> getStats() { return stats; }
    public void setStats(List<StatItemForm> stats) { this.stats = stats; }

    public String getAboutTitle() { return aboutTitle; }
    public void setAboutTitle(String aboutTitle) { this.aboutTitle = aboutTitle; }

    public String getAboutSubtitle() { return aboutSubtitle; }
    public void setAboutSubtitle(String aboutSubtitle) { this.aboutSubtitle = aboutSubtitle; }

    public String getAboutDescription() { return aboutDescription; }
    public void setAboutDescription(String aboutDescription) { this.aboutDescription = aboutDescription; }

    public String getAboutImageUrl() { return aboutImageUrl; }
    public void setAboutImageUrl(String aboutImageUrl) { this.aboutImageUrl = aboutImageUrl; }

    public List<ServiceItemForm> getServices() { return services; }
    public void setServices(List<ServiceItemForm> services) { this.services = services; }

    public List<PortfolioItemForm> getPortfolio() { return portfolio; }
    public void setPortfolio(List<PortfolioItemForm> portfolio) { this.portfolio = portfolio; }

    public List<TeamItemForm> getTeam() { return team; }
    public void setTeam(List<TeamItemForm> team) { this.team = team; }

    public List<TestimonialItemForm> getTestimonials() { return testimonials; }
    public void setTestimonials(List<TestimonialItemForm> testimonials) { this.testimonials = testimonials; }

    public List<FaqItemForm> getFaqs() { return faqs; }
    public void setFaqs(List<FaqItemForm> faqs) { this.faqs = faqs; }

    public String getContactAddress() { return contactAddress; }
    public void setContactAddress(String contactAddress) { this.contactAddress = contactAddress; }

    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }

    public String getSiteTitle() { return siteTitle; }
    public void setSiteTitle(String siteTitle) { this.siteTitle = siteTitle; }

    public String getSiteName() { return siteName; }
    public void setSiteName(String siteName) { this.siteName = siteName; }

    public String getSiteDescription() { return siteDescription; }
    public void setSiteDescription(String siteDescription) { this.siteDescription = siteDescription; }

    public String getLogoPath() { return logoPath; }
    public void setLogoPath(String logoPath) { this.logoPath = logoPath; }

    public List<String> getTechStack() { return techStack; }
    public void setTechStack(List<String> techStack) { this.techStack = techStack; }

    // Inner classes for form binding
    public static class StatItemForm {
        private String value;
        private String label;

        public String getValue() { return value; }
        public void setValue(String value) { this.value = value; }

        public String getLabel() { return label; }
        public void setLabel(String label) { this.label = label; }
    }

    public static class ServiceItemForm {
        private String icon;
        private String title;
        private String description;
        private String color;

        public String getIcon() { return icon; }
        public void setIcon(String icon) { this.icon = icon; }

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }

        public String getColor() { return color; }
        public void setColor(String color) { this.color = color; }
    }

    public static class PortfolioItemForm {
        private String title;
        private String description;
        private String image;
        private String alt;

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }

        public String getImage() { return image; }
        public void setImage(String image) { this.image = image; }

        public String getAlt() { return alt; }
        public void setAlt(String alt) { this.alt = alt; }
    }

    public static class TeamItemForm {
        private String name;
        private String role;
        private String image;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getRole() { return role; }
        public void setRole(String role) { this.role = role; }

        public String getImage() { return image; }
        public void setImage(String image) { this.image = image; }
    }

    public static class TestimonialItemForm {
        private String text;
        private String author;
        private String business;
        private String image;

        public String getText() { return text; }
        public void setText(String text) { this.text = text; }

        public String getAuthor() { return author; }
        public void setAuthor(String author) { this.author = author; }

        public String getBusiness() { return business; }
        public void setBusiness(String business) { this.business = business; }

        public String getImage() { return image; }
        public void setImage(String image) { this.image = image; }
    }

    public static class FaqItemForm {
        private String question;
        private String answer;

        public String getQuestion() { return question; }
        public void setQuestion(String question) { this.question = question; }

        public String getAnswer() { return answer; }
        public void setAnswer(String answer) { this.answer = answer; }
    }
}