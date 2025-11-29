package website.garapan.cmsimpel.controller;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IndexControllerTest {

    @Test
    void testIndexMethodReturnsCorrectViewName() {
        // Arrange
        IndexController controller = new IndexController();
        Model model = mock(Model.class);
        
        // Act
        String viewName = controller.index(model);
        
        // Assert
        assertEquals("index", viewName, "View name should be 'index'");
    }

    @Test
    void testIndexMethodAddsCorrectModelAttribute() {
        // Arrange
        IndexController controller = new IndexController();
        Model model = mock(Model.class);
        
        // Act
        controller.index(model);
        
        // Assert
        verify(model).addAttribute("message", "Halo CMS!");
    }
    
    @Test
    void testIndexMethodWithNullModel() {
        // Arrange
        IndexController controller = new IndexController();
        
        // Act & Assert
        assertThrows(Exception.class, () -> {
            controller.index(null);
        }, "Should handle null model appropriately");
    }
}