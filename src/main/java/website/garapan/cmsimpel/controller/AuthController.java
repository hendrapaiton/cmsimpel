package website.garapan.cmsimpel.controller;

import website.garapan.cmsimpel.model.Role;
import website.garapan.cmsimpel.model.RoleName;
import website.garapan.cmsimpel.model.User;
import website.garapan.cmsimpel.payload.JwtResponse;
import website.garapan.cmsimpel.payload.LoginRequest;
import website.garapan.cmsimpel.payload.SignupRequest;
import website.garapan.cmsimpel.repository.RoleRepository;
import website.garapan.cmsimpel.repository.UserRepository;
import website.garapan.cmsimpel.security.JwtUtils;
import website.garapan.cmsimpel.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);
        
        UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt, 
                                                 userDetails.getId(), 
                                                 userDetails.getUsername(), 
                                                 "", 
                                                 roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body("Error: Username is already taken!");
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                             encoder.encode(signUpRequest.getPassword()),
                             null);

        Set<Role> roles = new HashSet<>();

        if (signUpRequest.getRole() == null) {
            Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("User Role not set."));
            roles.add(userRole);
        } else {
            switch (signUpRequest.getRole()) {
            case "admin":
                Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                        .orElseThrow(() -> new RuntimeException("Admin Role not set."));
                roles.add(adminRole);
                
                Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("User Role not set."));
                roles.add(userRole);
                
                break;
            case "mod":
                Role modRole = roleRepository.findByName(RoleName.ROLE_MODERATOR)
                        .orElseThrow(() -> new RuntimeException("Moderator Role not set."));
                roles.add(modRole);
                
                Role modUserRole = roleRepository.findByName(RoleName.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("User Role not set."));
                roles.add(modUserRole);
                
                break;
            default:
                Role defaultUserRole = roleRepository.findByName(RoleName.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("User Role not set."));
                roles.add(defaultUserRole);
            }
        }

        user.setRoles(new ArrayList<>(roles));
        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully!");
    }
}