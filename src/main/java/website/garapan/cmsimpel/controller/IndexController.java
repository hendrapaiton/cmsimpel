package website.garapan.cmsimpel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        // Add basic message
        model.addAttribute("message", "Selamat Datang di CMS Kami!");

        // Add site info
        model.addAttribute("siteTitle", "Sistem Informasi dengan Teknologi AI Terbaru");
        model.addAttribute("siteName", "GARAPAN WEBSITE");

        // Add services data
        model.addAttribute("services", List.of(
            Map.of("icon", "bi-palette", "title", "UI/UX Design", "description", "Perancangan antarmuka yang estetis dan pengalaman pengguna yang intuitif untuk meningkatkan konversi.", "color", "warning"),
            Map.of("icon", "bi-laptop", "title", "Website Development", "description", "Pembuatan website company profile, toko online, hingga sistem informasi custom yang responsif dan SEO-friendly.", "color", "primary"),
            Map.of("icon", "bi-phone", "title", "Mobile Application", "description", "Pengembangan aplikasi mobile Android dan iOS menggunakan teknologi native maupun hybrid (Flutter/React Native).", "color", "success")
        ));

        // Add team data
        model.addAttribute("teamMembers", List.of(
            Map.of("name", "Zidane", "role", "Lead Developer", "image", "/assets/ceo_developer_portrait_1764371678999-Dm3iHmHD.png"),
            Map.of("name", "Ferdy", "role", "UI/UX Designer", "image", "/assets/casual_developer_cafe_1764371863292-C9pVxd7E.png"),
            Map.of("name", "Bintang", "role", "Backend Engineer", "image", "/assets/vr_gamer_tournament_1764372063645-BGMo98kq.png")
        ));

        // Add testimonials
        model.addAttribute("testimonials", List.of(
            Map.of("text", "Garapan Website sangat profesional. Website toko online kami jadi lebih cepat dan pengunjung jadi meningkat drastis. Desainnya juga sangat modern!", "author", "Putra", "business", "Ternak Cuan", "image", "/assets/petshop_cashier_owner_1764372376236-DFY-HlTK.png"),
            Map.of("text", "Tim yang sangat responsif dan solutif. Meski warung kami kecil, tetapi tetap dilayani dengan profesional. Sangat direkomendasikan!", "author", "Dwi", "business", "Warung Janda", "image", "/assets/bakery_owner_serving_1764402737-DlbgLZrx.png")
        ));

        // Add stats
        model.addAttribute("stats", List.of(
            Map.of("value", "80+", "label", "Proyek Selesai"),
            Map.of("value", "90%", "label", "Klien Puas"),
            Map.of("value", "7+", "label", "Tahun Pengalaman")
        ));

        // Add contact info
        model.addAttribute("contactInfo", Map.of(
            "address", "Jl. Hayam Wuruk No. 78 Jember 68135",
            "email", "hendra@usa.com",
            "phone", "+62 851 9814 1551"
        ));

        return "index";
    }
}