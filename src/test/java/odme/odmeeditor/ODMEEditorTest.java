package odme.odmeeditor;

import odme.jtreetograph.JtreeToGraphVariables;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static odme.odmeeditor.ODMEEditor.*;
import static org.junit.jupiter.api.Assertions.*;

class ODMEEditorTest {

    private String tempDirectory;
    @BeforeEach
    void setUp() throws Exception {
        // Create a temporary directory for testing
        Path tempDirPath = Files.createTempDirectory("temp");
        tempDirectory = tempDirPath.toAbsolutePath().toString();
    }

    @AfterEach
    void tearDown() throws Exception {
        // Delete the temporary directory and its contents
        File tempDir = new File(tempDirectory);
        deleteDirectory(tempDir);
    }

    @Test
    void testApplyGuiSES() {
        ODMEEditor.toolMode = "ses";

        // Apply Gui changes
        ODMEEditor.btnMode.setText("Domain Modelling");

        for (Map.Entry<String, JButton> entry : ToolBar.btnItems.entrySet()) {
            JButton btn = entry.getValue();
            assertTrue(btn.isVisible());
        }

        // Change MenuBar
        for (JMenuItem item : MenuBar.fileMenuItems) {
            assertFalse(item.isEnabled());
        }

        statusLabel.setText("Current Mode: Domain Modelling");

        tabbedPane.removeAll();
        tabbedPane.addTab("Ontology", XmlUtils.ontologyview);
        tabbedPane.addTab("Schema", XmlUtils.schemaview);

        ToolBar.btnScenario.setVisible(false);
        ODMEEditor.graphWindow.setTitle(projName);

        JTableHeader th = Variable.table.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        TableColumn tc = tcm.getColumn(3);
        assertEquals("Default Value", tc.getHeaderValue());
    }

    @Test
    void testSwitchToPes() {
        ODMEEditor.toolMode = "ses";

        // Simulate the conditions that trigger the mode switch
        ODMEEditor.toolMode = "pes";
        ODMEEditor.currentScenario = "InitScenario";
        ToolBar.btnScenario.setVisible(true);

        // Perform assertions to verify the expected changes
        assertEquals("pes", ODMEEditor.toolMode);
        assertEquals("InitScenario", ODMEEditor.currentScenario);
        assertTrue(ToolBar.btnScenario.isVisible());
        assertEquals("Value", Variable.table.getColumnModel().getColumn(3).getHeaderValue());

    }

    @Test
    void testChangePruneColor() {
        // Set up the necessary conditions for testing changePruneColor()
        ODMEEditor.toolMode = "ses";
        ODMEEditor.btnMode.setText("Scenario Modelling");
        ToolBar.btnScenario.setVisible(true);
        ODMEEditor.graphWindow.setTitle("InitScenario");

        // Call the method under test
        ODMEEditor.changePruneColor();

        // Perform assertions to verify the expected changes
        assertTrue(JtreeToGraphVariables.graph.getCellStyle("Entityp").equals("red"));

    }

    @Test
    void testSaveChanges() {
        // Set up the necessary conditions for testing saveChanges()
        ODMEEditor.toolMode = "ses";
        ODMEEditor.currentScenario = "InitScenario";
        ODMEEditor.fileLocation = "/path/to/file";

        // Save changes
        ODMEEditor.saveChanges();

        // Check that the files have been saved
        assertTrue(new File(ODMEEditor.fileLocation + "/" + ODMEEditor.currentScenario + "/ses.xsd").exists());
    }

    @Test
    void testNewProjectFolderCreation() {
        // Call the method under test
        ODMEEditor.newProjectFolderCreation();

        // Check that the project folder has been created in the temporary directory
        String projectFolder = tempDirectory + File.separator + ODMEEditor.projName;
        assertTrue(new File(projectFolder).exists());
    }

    // Helper method to recursively delete a directory and its contents
    private void deleteDirectory(File directory) {
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteDirectory(file);
                    } else {
                        file.delete();
                    }
                }
            }
            directory.delete();
        }
    }

    @Test
    void testTabbedPaneChange() {
        // Setup initial state
        ODMEEditor.toolMode = "ses";
        ODMEEditor.projName = "Main";
        ODMEEditor.fileLocation = "/path/to/project";
        ODMEEditor.currentScenario = "InitScenario";

        // Simulate tab change to XML
        ODMEEditor.tabbedPane.setSelectedIndex(0);

        // Assertions for SES tab
        assertEquals("Ontology", XmlUtils.sesview.getTitle());
        assertEquals(2, ODMEEditor.tabbedPane.getTabCount());
        assertTrue(ToolBar.btnScenario.isVisible());
        assertEquals("Value", Variable.table.getColumnModel().getColumn(3).getHeaderValue());

        // Simulate tab change to Schema
        ODMEEditor.tabbedPane.setSelectedIndex(1);

        // Assertions for Schema tab
        assertEquals("Schema", XmlUtils.schemaview.getTitle());
        assertEquals(2, ODMEEditor.tabbedPane.getTabCount());
    }

}