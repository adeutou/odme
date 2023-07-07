package odme.odmeeditor;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;


class ConsoleTest {

    @Test
    public void testConsoleKeyPressedAction() {
        // Create a new Console object.
        Console console = new Console();

        // Simulate a key press in the console window.
        KeyEvent enterEvent = new KeyEvent(console.consoleText, KeyEvent.KEY_PRESSED, System.currentTimeMillis(),
                KeyEvent.SHIFT_DOWN_MASK, KeyEvent.VK_ENTER, KeyEvent.CHAR_UNDEFINED);
        console.simulateConsoleKeyPress(enterEvent);

        // Check if the console text was updated correctly.
        assertEquals(">>\n\n>>", console.consoleText.getText());
    }

    @Test
    void testAddConsoleOutput() {
        Console console = new Console();
        console.addConsoleOutput("This is a test message.");
        assertEquals("This is a test message.\n", console.consoleText.getText());
    }

    @Test
    void testClearConsole() {
        Console console = new Console();
        console.addConsoleOutput("This is a test message.");
        console.clearConsole();
        assertEquals(">>", console.consoleText.getText());
    }
}