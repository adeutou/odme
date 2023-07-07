package odme.odmeeditor;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GraphWindowTest {

    /**
     * This test case creates a new GraphWindow object and then verifies that the title, resizable,
     * closable, maximizable, and iconifiable properties of the object are set as expected.
     */

    @Test
    void testGraphWindow() {
        GraphWindow graphWindow = new GraphWindow();
        assertEquals(ODMEEditor.projName, graphWindow.getTitle());
        assertFalse(graphWindow.isResizable());
        assertFalse(graphWindow.isClosable());
        assertFalse(graphWindow.isMaximizable());
        assertFalse(graphWindow.isIconifiable());
    }
}