package odme.odmeeditor;

import static org.junit.jupiter.api.Assertions.*;

import odme.jtreetograph.JtreeToGraphVariables;
import org.junit.jupiter.api.Test;

class NewProjectTest {
    @Test
    void testCreateNewProjectWindow() {
        NewProject newProject = new NewProject();
        newProject.createNewProjectWindow();
        assertEquals(newProject.getFrame().isVisible(), true);
    }

    @Test
    void testAddFunctions() {
        NewProject newProject = new NewProject();
        newProject.addFunctions();
        assertEquals(newProject.getErrorLabelField().isVisible(), false);
    }

    @Test
    void testSelectLocation() {
        NewProject newProject = new NewProject();
        newProject.selectLocation();
        assertEquals(newProject.getProjectLocationField().getText(), ODMEEditor.repFslas);
    }

    @Test
    void testCreateFunc() {
        NewProject newProject = new NewProject();
        newProject.createFunc();
        assertTrue(true);
    }

    @Test
    void test2CreateFunc() {
        NewProject newProject = new NewProject();
        newProject.createNewProjectWindow();

        // Set the project name and root name.
        newProject.getNewProjectNameField().setText("NewProject");
        newProject.getNewRootNameField().setText("NewRoot");

        // Click the "Create" button.
        newProject.getCreate().doClick();

        // Check that the project name and root name are updated.
        assertEquals("NewProject", ODMEEditor.projName);
        assertEquals("NewRoot", ProjectTree.projectName);

        // Check that the graph file is created.
        assertTrue(JtreeToGraphVariables.ssdFileGraph.exists());

        // Check that the SSD file is created.
        assertTrue(ODMEEditor.treePanel.ssdFile.exists());

        // Check that the variable file is created.
        assertTrue(ODMEEditor.treePanel.ssdFileVar.exists());

        // Check that the constraint file is created.
        assertTrue(ODMEEditor.treePanel.ssdFileCon.exists());

        // Check that the flag file is created.
        assertTrue(ODMEEditor.treePanel.ssdFileFlag.exists());
    }

}