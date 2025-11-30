package website.garapan.cmsimpel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import website.garapan.cmsimpel.model.FormLandingPageContent;
import website.garapan.cmsimpel.service.LandingPageService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class AdminController {

    @Autowired
    private LandingPageService landingPageService;

    // Folder untuk menyimpan file upload
    private static final String UPLOAD_DIR = "src/main/resources/static/uploads/";

    @GetMapping("/admin")
    public String adminDashboard(Model model) {
        FormLandingPageContent formContent = landingPageService.convertToFormContent(landingPageService.getLandingPageContent());
        model.addAttribute("content", formContent);
        return "admin/dashboard";
    }

    @PostMapping("/admin/save")
    public String saveLandingPageContent(FormLandingPageContent content, @RequestParam("logoFile") MultipartFile logoFile) {
        // Jika ada file logo yang diupload, simpan dan perbarui path
        if (logoFile != null && !logoFile.isEmpty()) {
            try {
                // Validasi tipe file
                String contentType = logoFile.getContentType();
                if (contentType != null && (contentType.equals("image/jpeg") || contentType.equals("image/png") || contentType.equals("image/jpg"))) {
                    // Membuat direktori jika belum ada
                    Path uploadPath = Paths.get(UPLOAD_DIR);
                    if (!Files.exists(uploadPath)) {
                        Files.createDirectories(uploadPath);
                    }

                    // Validasi nama file untuk mencegah path traversal
                    String fileName = logoFile.getOriginalFilename();
                    if (fileName != null) {
                        // Bersihkan nama file dari karakter berbahaya
                        fileName = sanitizeFileName(fileName);

                        // Simpan file
                        Path filePath = uploadPath.resolve(fileName);
                        logoFile.transferTo(filePath.toFile());

                        // Perbarui path logo di content
                        content.setLogoPath("/uploads/" + fileName);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace(); // Log error
                // Gunakan path logo yang sudah ada jika upload gagal
            }
        }

        landingPageService.updateLandingPageContent(content);
        return "redirect:/admin?success";
    }

    // Metode untuk membersihkan nama file dari karakter berbahaya
    private String sanitizeFileName(String fileName) {
        // Hanya izinkan huruf, angka, titik, dan underscore
        fileName = fileName.replaceAll("[^a-zA-Z0-9._-]", "_");
        // Batasi panjang nama file
        if (fileName.length() > 200) {
            String extension = "";
            int lastDotIndex = fileName.lastIndexOf('.');
            if (lastDotIndex > 0) {
                extension = fileName.substring(lastDotIndex);
                fileName = fileName.substring(0, lastDotIndex);
            }
            fileName = fileName.substring(0, 190) + extension;
        }
        return fileName;
    }
}