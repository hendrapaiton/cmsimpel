package website.garapan.cmsimpel.service;

import org.springframework.stereotype.Service;
import website.garapan.cmsimpel.model.FormLandingPageContent;
import website.garapan.cmsimpel.model.LandingPageContent;

import jakarta.annotation.PostConstruct;
import java.util.*;

@Service
public class LandingPageService {

    private LandingPageContent landingPageContent;

    @PostConstruct
    public void initializeDefaultContent() {
        landingPageContent = getDefaultLandingPageContent();
    }

    public LandingPageContent getLandingPageContent() {
        if (landingPageContent == null) {
            initializeDefaultContent();
        }
        return landingPageContent;
    }

    public void updateLandingPageContent(FormLandingPageContent formContent) {
        this.landingPageContent = convertFormToLandingPageContent(formContent);
    }

    private LandingPageContent convertFormToLandingPageContent(FormLandingPageContent formContent) {
        LandingPageContent content = new LandingPageContent();

        // Hero Section
        content.setHeroTitle(formContent.getHeroTitle());
        content.setHeroSubtitle(formContent.getHeroSubtitle());
        content.setHeroButtonText1(formContent.getHeroButtonText1());
        content.setHeroButtonLink1(formContent.getHeroButtonLink1());
        content.setHeroButtonText2(formContent.getHeroButtonText2());
        content.setHeroButtonLink2(formContent.getHeroButtonLink2());
        content.setHeroImage(formContent.getHeroImage());

        // Stats Section
        List<Map<String, String>> stats = new ArrayList<>();
        if (formContent.getStats() != null) {
            for (FormLandingPageContent.StatItemForm stat : formContent.getStats()) {
                if (stat != null && stat.getValue() != null && stat.getLabel() != null) {
                    Map<String, String> statMap = new HashMap<>();
                    statMap.put("value", stat.getValue());
                    statMap.put("label", stat.getLabel());
                    stats.add(statMap);
                }
            }
        }
        content.setStats(stats);

        // About Section
        content.setAboutTitle(formContent.getAboutTitle());
        content.setAboutSubtitle(formContent.getAboutSubtitle());
        content.setAboutDescription(formContent.getAboutDescription());
        content.setAboutImageUrl(formContent.getAboutImageUrl());

        // Services Section
        List<Map<String, String>> services = new ArrayList<>();
        if (formContent.getServices() != null) {
            for (FormLandingPageContent.ServiceItemForm service : formContent.getServices()) {
                if (service != null && service.getTitle() != null) {
                    Map<String, String> serviceMap = new HashMap<>();
                    serviceMap.put("icon", service.getIcon() != null ? service.getIcon() : "bi-briefcase");
                    serviceMap.put("title", service.getTitle());
                    serviceMap.put("description", service.getDescription() != null ? service.getDescription() : "");
                    serviceMap.put("color", service.getColor() != null ? service.getColor() : "primary");
                    services.add(serviceMap);
                }
            }
        }
        content.setServices(services);

        // Portfolio Section
        List<Map<String, String>> portfolio = new ArrayList<>();
        if (formContent.getPortfolio() != null) {
            for (FormLandingPageContent.PortfolioItemForm project : formContent.getPortfolio()) {
                if (project != null && project.getTitle() != null) {
                    Map<String, String> projectMap = new HashMap<>();
                    projectMap.put("title", project.getTitle());
                    projectMap.put("description", project.getDescription() != null ? project.getDescription() : "");
                    projectMap.put("image", project.getImage() != null ? project.getImage() : "");
                    projectMap.put("alt", project.getAlt() != null ? project.getAlt() : project.getTitle());
                    portfolio.add(projectMap);
                }
            }
        }
        content.setPortfolio(portfolio);

        // Team Section
        List<Map<String, String>> team = new ArrayList<>();
        if (formContent.getTeam() != null) {
            for (FormLandingPageContent.TeamItemForm member : formContent.getTeam()) {
                if (member != null && member.getName() != null) {
                    Map<String, String> memberMap = new HashMap<>();
                    memberMap.put("name", member.getName());
                    memberMap.put("role", member.getRole() != null ? member.getRole() : "");
                    memberMap.put("image", member.getImage() != null ? member.getImage() : "");
                    team.add(memberMap);
                }
            }
        }
        content.setTeam(team);

        // Testimonials Section
        List<Map<String, String>> testimonials = new ArrayList<>();
        if (formContent.getTestimonials() != null) {
            for (FormLandingPageContent.TestimonialItemForm testimonial : formContent.getTestimonials()) {
                if (testimonial != null && testimonial.getAuthor() != null) {
                    Map<String, String> testimonialMap = new HashMap<>();
                    testimonialMap.put("text", testimonial.getText() != null ? testimonial.getText() : "");
                    testimonialMap.put("author", testimonial.getAuthor());
                    testimonialMap.put("business", testimonial.getBusiness() != null ? testimonial.getBusiness() : "");
                    testimonialMap.put("image", testimonial.getImage() != null ? testimonial.getImage() : "");
                    testimonials.add(testimonialMap);
                }
            }
        }
        content.setTestimonials(testimonials);

        // FAQ Section
        List<Map<String, String>> faqs = new ArrayList<>();
        if (formContent.getFaqs() != null) {
            for (FormLandingPageContent.FaqItemForm faq : formContent.getFaqs()) {
                if (faq != null && faq.getQuestion() != null) {
                    Map<String, String> faqMap = new HashMap<>();
                    faqMap.put("question", faq.getQuestion());
                    faqMap.put("answer", faq.getAnswer() != null ? faq.getAnswer() : "");
                    faqs.add(faqMap);
                }
            }
        }
        content.setFaqs(faqs);

        // Contact Section
        Map<String, String> contactInfo = new HashMap<>();
        contactInfo.put("address", formContent.getContactAddress() != null ? formContent.getContactAddress() : "");
        contactInfo.put("email", formContent.getContactEmail() != null ? formContent.getContactEmail() : "");
        contactInfo.put("phone", formContent.getContactPhone() != null ? formContent.getContactPhone() : "");
        content.setContactInfo(contactInfo);

        // Site Info
        content.setSiteTitle(formContent.getSiteTitle());
        content.setSiteName(formContent.getSiteName());
        content.setSiteDescription(formContent.getSiteDescription());
        content.setLogoPath(formContent.getLogoPath());

        return content;
    }

    private LandingPageContent getDefaultLandingPageContent() {
        LandingPageContent content = new LandingPageContent();

        // Hero Section
        content.setHeroTitle("Wujudkan Ide Digital <br /> <span class=\"text-gradient\">Menjadi Maha Karya</span>");
        content.setHeroSubtitle("Kami membantu mewujudkan ide nyata Anda menjadi sistem informasi mutakhir dengan teknologi AI terbaru.");
        content.setHeroButtonText1("Mulai Proyek");
        content.setHeroButtonLink1("#contact");
        content.setHeroButtonText2("Lihat Portfolio");
        content.setHeroButtonLink2("#product");
        content.setHeroImage("/logo.png");

        // Stats Section
        content.setStats(Arrays.asList(
            createStat("80+", "Proyek Selesai"),
            createStat("90%", "Klien Puas"),
            createStat("7+", "Tahun Pengalaman")
        ));

        // About Section
        content.setAboutTitle("Mitra Digital untuk Perkembangan Institusi Anda");
        content.setAboutSubtitle("Tentang Kami");
        content.setAboutDescription("Garapan Website bukan sekadar vendor, tapi mitra strategis. Kami memahami bahwa setiap baris kode yang kami tulis adalah investasi untuk masa depan institusi Anda. Dengan tim yang berdedikasi dan berpengalaman, kami siap menghadirkan solusi digital yang tidak hanya indah, tapi juga fungsional dan profesional.");
        content.setAboutImageUrl("https://images.unsplash.com/photo-1522071820081-009f0129c71c?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80");

        // Services Section
        content.setServices(Arrays.asList(
            createService("bi-palette", "UI/UX Design", "Perancangan antarmuka yang estetis dan pengalaman pengguna yang intuitif untuk meningkatkan konversi.", "warning"),
            createService("bi-laptop", "Website Development", "Pembuatan website company profile, toko online, hingga sistem informasi custom yang responsif dan SEO-friendly.", "primary"),
            createService("bi-phone", "Mobile Application", "Pengembangan aplikasi mobile Android dan iOS menggunakan teknologi native maupun hybrid (Flutter/React Native).", "success")
        ));

        // Portfolio Section
        content.setPortfolio(Arrays.asList(
            createPortfolio("Fashion E-Commerce Website", "E-Commerce Fashion", "Web Development, UI/UX", "/assets/fashion_web_desktop_1764339749885-BqN3-cmJ.png"),
            createPortfolio("Sistem Manajemen RS Dashboard", "Sistem Manajemen RS", "Web App, Dashboard", "/assets/simrs_dashboard_1764371322765-WNyIQfIv.png")
        ));

        // Team Section
        content.setTeam(Arrays.asList(
            createTeam("Zidane", "Lead Developer", "/assets/ceo_developer_portrait_1764371678999-Dm3iHmHD.png"),
            createTeam("Ferdy", "UI/UX Designer", "/assets/casual_developer_cafe_1764371863292-C9pVxd7E.png"),
            createTeam("Bintang", "Backend Engineer", "/assets/vr_gamer_tournament_1764372063645-BGMo98kq.png")
        ));

        // Testimonials Section
        content.setTestimonials(Arrays.asList(
            createTestimonial("Garapan Website sangat profesional. Website toko online kami jadi lebih cepat dan pengunjung jadi meningkat drastis. Desainnya juga sangat modern!", "Putra", "Ternak Cuan", "/assets/petshop_cashier_owner_1764372376236-DFY-HlTK.png"),
            createTestimonial("Tim yang sangat responsif dan solutif. Meski warung kami kecil, tetapi tetap dilayani dengan profesional. Sangat direkomendasikan!", "Dwi", "Warung Janda", "/assets/bakery_owner_serving_1764402737-DlbgLZrx.png")
        ));

        // FAQ Section
        content.setFaqs(Arrays.asList(
            createFaq("Berapa lama waktu pengerjaan website?", "Waktu pengerjaan bervariasi tergantung kompleksitas. Untuk landing page sederhana sekitar 7-14 hari, sedangkan untuk sistem yang kompleks bisa memakan waktu 1-3 bulan."),
            createFaq("Apakah ada garansi setelah website jadi?", "Ya, kami memberikan garansi maintenance gratis selama 3 bulan pertama untuk memastikan website berjalan lancar tanpa bug."),
            createFaq("Apakah hosting dan domain disediakan?", "Untuk paket tertentu, hosting dan domain sudah termasuk untuk tahun pertama. Namun untuk sistem besar, kami menyarankan menggunakan server sendiri yang kami bantu setup.")
        ));

        // Contact Section
        content.setContactInfo(createContactInfo("Jl. Hayam Wuruk No. 78 Jember 68135", "hendra@usa.com", "+62 851 9814 1551"));

        // Site Info
        content.setSiteTitle("Sistem Informasi dengan Teknologi AI Terbaru");
        content.setSiteName("GARAPAN WEBSITE");
        content.setSiteDescription("Selamat Datang di CMS Kami!");
        content.setLogoPath("/logo.png");

        return content;
    }

    private Map<String, String> createStat(String value, String label) {
        Map<String, String> stat = new HashMap<>();
        stat.put("value", value);
        stat.put("label", label);
        return stat;
    }

    private Map<String, String> createService(String icon, String title, String description, String color) {
        Map<String, String> service = new HashMap<>();
        service.put("icon", icon);
        service.put("title", title);
        service.put("description", description);
        service.put("color", color);
        return service;
    }

    private Map<String, String> createPortfolio(String alt, String title, String description, String image) {
        Map<String, String> portfolio = new HashMap<>();
        portfolio.put("alt", alt);
        portfolio.put("title", title);
        portfolio.put("description", description);
        portfolio.put("image", image);
        return portfolio;
    }

    private Map<String, String> createTeam(String name, String role, String image) {
        Map<String, String> team = new HashMap<>();
        team.put("name", name);
        team.put("role", role);
        team.put("image", image);
        return team;
    }

    private Map<String, String> createTestimonial(String text, String author, String business, String image) {
        Map<String, String> testimonial = new HashMap<>();
        testimonial.put("text", text);
        testimonial.put("author", author);
        testimonial.put("business", business);
        testimonial.put("image", image);
        return testimonial;
    }

    private Map<String, String> createFaq(String question, String answer) {
        Map<String, String> faq = new HashMap<>();
        faq.put("question", question);
        faq.put("answer", answer);
        return faq;
    }

    private Map<String, String> createContactInfo(String address, String email, String phone) {
        Map<String, String> contact = new HashMap<>();
        contact.put("address", address);
        contact.put("email", email);
        contact.put("phone", phone);
        return contact;
    }

    // Convert LandingPageContent to FormLandingPageContent for display in the form
    public FormLandingPageContent convertToFormContent(LandingPageContent content) {
        FormLandingPageContent formContent = new FormLandingPageContent();

        // Hero Section
        formContent.setHeroTitle(content.getHeroTitle());
        formContent.setHeroSubtitle(content.getHeroSubtitle());
        formContent.setHeroButtonText1(content.getHeroButtonText1());
        formContent.setHeroButtonLink1(content.getHeroButtonLink1());
        formContent.setHeroButtonText2(content.getHeroButtonText2());
        formContent.setHeroButtonLink2(content.getHeroButtonLink2());
        formContent.setHeroImage(content.getHeroImage());

        // Stats Section
        List<FormLandingPageContent.StatItemForm> stats = new ArrayList<>();
        if (content.getStats() != null) {
            for (Map<String, String> statMap : content.getStats()) {
                FormLandingPageContent.StatItemForm stat = new FormLandingPageContent.StatItemForm();
                stat.setValue(statMap.get("value"));
                stat.setLabel(statMap.get("label"));
                stats.add(stat);
            }
        }
        formContent.setStats(stats);

        // About Section
        formContent.setAboutTitle(content.getAboutTitle());
        formContent.setAboutSubtitle(content.getAboutSubtitle());
        formContent.setAboutDescription(content.getAboutDescription());
        formContent.setAboutImageUrl(content.getAboutImageUrl());

        // Services Section
        List<FormLandingPageContent.ServiceItemForm> services = new ArrayList<>();
        if (content.getServices() != null) {
            for (Map<String, String> serviceMap : content.getServices()) {
                FormLandingPageContent.ServiceItemForm service = new FormLandingPageContent.ServiceItemForm();
                service.setIcon(serviceMap.get("icon"));
                service.setTitle(serviceMap.get("title"));
                service.setDescription(serviceMap.get("description"));
                service.setColor(serviceMap.get("color"));
                services.add(service);
            }
        }
        formContent.setServices(services);

        // Portfolio Section
        List<FormLandingPageContent.PortfolioItemForm> portfolio = new ArrayList<>();
        if (content.getPortfolio() != null) {
            for (Map<String, String> projectMap : content.getPortfolio()) {
                FormLandingPageContent.PortfolioItemForm project = new FormLandingPageContent.PortfolioItemForm();
                project.setTitle(projectMap.get("title"));
                project.setDescription(projectMap.get("description"));
                project.setImage(projectMap.get("image"));
                project.setAlt(projectMap.get("alt"));
                portfolio.add(project);
            }
        }
        formContent.setPortfolio(portfolio);

        // Team Section
        List<FormLandingPageContent.TeamItemForm> team = new ArrayList<>();
        if (content.getTeam() != null) {
            for (Map<String, String> memberMap : content.getTeam()) {
                FormLandingPageContent.TeamItemForm member = new FormLandingPageContent.TeamItemForm();
                member.setName(memberMap.get("name"));
                member.setRole(memberMap.get("role"));
                member.setImage(memberMap.get("image"));
                team.add(member);
            }
        }
        formContent.setTeam(team);

        // Testimonials Section
        List<FormLandingPageContent.TestimonialItemForm> testimonials = new ArrayList<>();
        if (content.getTestimonials() != null) {
            for (Map<String, String> testimonialMap : content.getTestimonials()) {
                FormLandingPageContent.TestimonialItemForm testimonial = new FormLandingPageContent.TestimonialItemForm();
                testimonial.setText(testimonialMap.get("text"));
                testimonial.setAuthor(testimonialMap.get("author"));
                testimonial.setBusiness(testimonialMap.get("business"));
                testimonial.setImage(testimonialMap.get("image"));
                testimonials.add(testimonial);
            }
        }
        formContent.setTestimonials(testimonials);

        // FAQ Section
        List<FormLandingPageContent.FaqItemForm> faqs = new ArrayList<>();
        if (content.getFaqs() != null) {
            for (Map<String, String> faqMap : content.getFaqs()) {
                FormLandingPageContent.FaqItemForm faq = new FormLandingPageContent.FaqItemForm();
                faq.setQuestion(faqMap.get("question"));
                faq.setAnswer(faqMap.get("answer"));
                faqs.add(faq);
            }
        }
        formContent.setFaqs(faqs);

        // Contact Section
        formContent.setContactAddress(content.getContactInfo().get("address"));
        formContent.setContactEmail(content.getContactInfo().get("email"));
        formContent.setContactPhone(content.getContactInfo().get("phone"));

        // Site Info
        formContent.setSiteTitle(content.getSiteTitle());
        formContent.setSiteName(content.getSiteName());
        formContent.setSiteDescription(content.getSiteDescription());
        formContent.setLogoPath(content.getLogoPath());

        return formContent;
    }
}