package website.garapan.cmsimpel.config;

import website.garapan.cmsimpel.model.Role;
import website.garapan.cmsimpel.model.RoleName;
import website.garapan.cmsimpel.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create default roles if they don't exist
        if (roleRepository.findByName(RoleName.ROLE_USER).isEmpty()) {
            roleRepository.save(new Role(RoleName.ROLE_USER));
        }

        if (roleRepository.findByName(RoleName.ROLE_ADMIN).isEmpty()) {
            roleRepository.save(new Role(RoleName.ROLE_ADMIN));
        }

        if (roleRepository.findByName(RoleName.ROLE_MODERATOR).isEmpty()) {
            roleRepository.save(new Role(RoleName.ROLE_MODERATOR));
        }
    }
}