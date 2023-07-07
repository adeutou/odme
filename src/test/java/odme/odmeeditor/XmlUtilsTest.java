package odme.odmeeditor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XmlUtilsTest {

    @Test
    void testInitView() {
        XMLViewer view = XmlUtils.initView("Test View");
        assertEquals(200, view.getWidth());
        assertEquals(200, view.getHeight());
        assertEquals("Test View", view.getTitle());
        assertTrue(view.textArea.isEditable() == false);
    }

    @Test
    void testShowViewer() {
        String fileLocation = "/tmp";
        String projName = "project1";
        String fileName = "ontology.xml";
        XMLViewer view = XmlUtils.initView("Test View");
        XmlUtils.showViewer(fileLocation, projName, fileName, view);
        assertEquals(fileLocation + "/" + projName + "/"+fileName, view.textArea.getText());
    }
}