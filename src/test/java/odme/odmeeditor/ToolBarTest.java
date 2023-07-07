package odme.odmeeditor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import javax.swing.JButton;

class ToolBarTest {

    @Test
    void testSelector() {
        ToolBar toolBar = new ToolBar(null);
        toolBar.selector();
        assertEquals("", ODMEEditor.nodeAddDetector);
    }

    @Test
    void testAddEntity() {
        ToolBar toolBar = new ToolBar(null);
        toolBar.addEntity();
        assertEquals("entity", ODMEEditor.nodeAddDetector);
    }

    @Test
    void testAddAspect() {
        ToolBar toolBar = new ToolBar(null);
        toolBar.addAspect();
        assertEquals("aspect", ODMEEditor.nodeAddDetector);
    }

    @Test
    void testAddSpecialization() {
        ToolBar toolBar = new ToolBar(null);
        toolBar.addSpecialization();
        assertEquals("specialization", ODMEEditor.nodeAddDetector);
    }

    @Test
    void testAddMultiAspect() {
        ToolBar toolBar = new ToolBar(null);
        toolBar.addMultiAspect();
        assertEquals("multiaspect", ODMEEditor.nodeAddDetector);
    }

    @Test
    void testDeleteNode() {
        ToolBar toolBar = new ToolBar(null);
        toolBar.deleteNode();
        assertEquals("delete", ODMEEditor.nodeAddDetector);
    }

    @Test
    void testSaveGraph() {
        ToolBar toolBar = new ToolBar(null);
        toolBar.saveGraph();
    }

    @Test
    void testUndo() {
        ToolBar toolBar = new ToolBar(null);
        toolBar.undo();
    }

    @Test
    void testRedo() {
        ToolBar toolBar = new ToolBar(null);
        toolBar.redo();
    }

    @Test
    void testZoomIn() {
        ToolBar toolBar = new ToolBar(null);
        toolBar.zoomIn();
    }

    @Test
    void testZoomOut() {
        ToolBar toolBar = new ToolBar(null);
        toolBar.zoomOut();
    }

    @Test
    void testValidation() {
        ToolBar toolBar = new ToolBar(null);
        // Mock any necessary dependencies and setup the test environment
        toolBar.validation();
    }

    @Test
    void testShow() {
        ToolBar toolBar = new ToolBar(null);
        toolBar.show();
        // You can access the created JButtons from the btnItems map if needed
        JButton addEntityButton = ToolBar.btnItems.get("Add Entity");
        assertNotNull(addEntityButton);
    }
}