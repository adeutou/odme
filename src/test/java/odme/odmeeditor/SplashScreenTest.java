package odme.odmeeditor;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


class SplashScreenTest {

    @Test
    public void testCreateGUI() {
        SplashScreen splashScreen = new SplashScreen(1);
        assertEquals(600, splashScreen.getFrame().getWidth());
        assertEquals(380, splashScreen.getFrame().getHeight());
        assertEquals(Color.white, splashScreen.getFrame().getContentPane().getBackground());
    }

    @Test
    public void testAddImage() {
        SplashScreen splashScreen = new SplashScreen(1);
        assertEquals(600, splashScreen.getImage().getWidth());
        assertEquals(230, splashScreen.getFrame().getHeight());
    }

    @Test
    public void testAddText() {
        SplashScreen splashScreen = new SplashScreen(1);
        assertEquals(26, splashScreen.getText().getFont().getSize());
        assertEquals(new Color(0x04773b), splashScreen.getText().getForeground());
    }

    @Test
    public void testAddProgressBar() {
        SplashScreen splashScreen = new SplashScreen(1);
        assertEquals(400, splashScreen.getProgressBar().getWidth());
        assertEquals(30, splashScreen.getProgressBar().getHeight());
        assertEquals(Color.WHITE, splashScreen.getProgressBar().getBackground());
        assertEquals(new Color(0x04773b), splashScreen.getProgressBar().getForeground());
    }

    @Test
    public void testRunningPBar() {
        SplashScreen splashScreen = new SplashScreen(1);
        splashScreen.runningPBar();
        assertEquals(100, splashScreen.getProgressBar().getValue());
    }

}