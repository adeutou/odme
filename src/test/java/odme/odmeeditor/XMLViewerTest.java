package odme.odmeeditor;

import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XMLViewerTest {

    @Test
    void testXMLViewer() {
        XMLViewer viewer = new XMLViewer();
        assertEquals(20, viewer.textArea.getHeight());
        assertEquals(60, viewer.textArea.getWidth());
        assertEquals(SyntaxConstants.SYNTAX_STYLE_XML, viewer.textArea.getSyntaxEditingStyle());
        assertTrue(viewer.textArea.isCodeFoldingEnabled());
        assertEquals("XML Viewer", viewer.getTitle());
    }
}