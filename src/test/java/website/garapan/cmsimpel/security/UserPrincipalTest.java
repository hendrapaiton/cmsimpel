package website.garapan.cmsimpel.security;

import website.garapan.cmsimpel.model.Role;
import website.garapan.cmsimpel.model.RoleName;
import website.garapan.cmsimpel.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.*;

class UserPrincipalTest {

    private User mockUser;

    @BeforeEach
    void setUp() {
        Role userRole = new Role(RoleName.ROLE_USER);
        mockUser = new User("testuser", "password", Arrays.asList(userRole));
        mockUser.setId(1L);
    }

    @Test
    void testCreateUserPrincipalFromUser() {
        // Act
        UserPrincipal userPrincipal = UserPrincipal.create(mockUser);

        // Assert
        assertNotNull(userPrincipal);
        assertEquals(mockUser.getId(), userPrincipal.getId());
        assertEquals(mockUser.getUsername(), userPrincipal.getUsername());
        assertEquals(mockUser.getPassword(), userPrincipal.getPassword());

        Collection<? extends GrantedAuthority> authorities = userPrincipal.getAuthorities();
        assertEquals(1, authorities.size());
        assertEquals("ROLE_USER", authorities.iterator().next().getAuthority());
    }

    @Test
    void testUserPrincipalEnabledMethods() {
        // Act
        UserPrincipal userPrincipal = UserPrincipal.create(mockUser);

        // Assert
        assertTrue(userPrincipal.isAccountNonExpired());
        assertTrue(userPrincipal.isAccountNonLocked());
        assertTrue(userPrincipal.isCredentialsNonExpired());
        assertTrue(userPrincipal.isEnabled());
    }
}