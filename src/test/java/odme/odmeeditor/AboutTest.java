package odme.odmeeditor;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import javax.swing.JFrame;
import java.lang.reflect.Field;

class AboutTest {

    /*
    @Test
    void testAboutGUI() {
        About about = new About();

        // Call the aboutGUI method
        about.aboutGUI();

        // Check if the frame is visible
        assertTrue(about.frame.isVisible());

        // Check if the frame title is set correctly
        assertEquals("About Editor", about.frame.getTitle());

        // Check if the frame is not resizable
        assertFalse(about.frame.isResizable());

        // Check if the frame size is set correctly
        assertEquals(450, about.frame.getWidth());
        assertEquals(300, about.frame.getHeight());

        // Check if the frame position is set correctly
        int expectedX = (java.awt.Toolkit.getDefaultToolkit().getScreenSize().width - 450) / 2;
        int expectedY = (java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - 300) / 2;
        assertEquals(expectedX, about.frame.getX());
        assertEquals(expectedY, about.frame.getY());

        // Check if the frame contains the expected number of panels
        assertEquals(3, about.frame.getContentPane().getComponentCount());
    }*/

    @Test
    void testAboutGUI() throws Exception {
        About about = new About();

        // Call the aboutGUI method
        about.aboutGUI();

        // Use reflection to access the private frame field
        Field frameField = About.class.getDeclaredField("frame");
        frameField.setAccessible(true);
        JFrame frame = (JFrame) frameField.get(about);

        // Check if the frame is visible
        assertTrue(frame.isVisible());

        // Check if the frame title is set correctly
        assertEquals("About Editor", frame.getTitle());

        // Check if the frame is not resizable
        assertFalse(frame.isResizable());

        // Check if the frame size is set correctly
        assertEquals(450, frame.getWidth());
        assertEquals(300, frame.getHeight());

        // Check if the frame position is set correctly
        int expectedX = (java.awt.Toolkit.getDefaultToolkit().getScreenSize().width - 450) / 2;
        int expectedY = (java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - 300) / 2;
        assertEquals(expectedX, frame.getX());
        assertEquals(expectedY, frame.getY());

        // Check if the frame contains the expected number of panels
        assertEquals(3, frame.getContentPane().getComponentCount());
    }
}