package odme.odmeeditor;

import static org.junit.jupiter.api.Assertions.*;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

class MenuBarTest {

    @Test
    void testSaveScenario() throws IOException, ParseException {
        File scenariosFile = new File("scenarios.json");
        if (scenariosFile.exists()) {
            scenariosFile.delete();
        }

        MenuBar menuBar = new MenuBar(null);
        menuBar.saveScenario();

        assertTrue(scenariosFile.exists());

        JSONParser jsonParser = new JSONParser();
        Object obj = null;
        try (FileReader reader = new FileReader(scenariosFile)) {
            obj = jsonParser.parse(reader);
        }

        JSONArray data = (JSONArray) obj;
        assertEquals(1, data.size());

        JSONObject jo = (JSONObject) data.get(0);
        assertEquals("Scenario1", jo.get("name"));
        assertEquals("", jo.get("risk"));
        assertEquals("", jo.get("remarks"));
    }

    @Test
    void testCreateScenario() throws IOException, ParseException {
        File scenariosFile = new File("scenarios.json");
        if (scenariosFile.exists()) {
            scenariosFile.delete();
        }

        MenuBar menuBar = new MenuBar(null);
        menuBar.createScenario("Scenario1");

        assertTrue(scenariosFile.exists());

        JSONParser jsonParser = new JSONParser();
        Object obj = null;
        try (FileReader reader = new FileReader(scenariosFile)) {
            obj = jsonParser.parse(reader);
        }

        JSONArray data = (JSONArray) obj;
        assertEquals(1, data.size());

        JSONObject jo = (JSONObject) data.get(0);
        assertEquals("Scenario1", jo.get("name"));
        assertEquals("", jo.get("risk"));
        assertEquals("", jo.get("remarks"));
    }

    /*@Test
    void testNewFunc() throws FileNotFoundException, IOException {
        NewProject newProject = new NewProject();
        File newProjectFile = newProject.createNewProjectFile();

        assertTrue(newProjectFile.exists());
    }

    @Test
    void testOpenFunc() throws FileNotFoundException, IOException {
        OpenProject openProject = new OpenProject();
        File openProjectFile = openProject.openExistingProjectFile();

        assertTrue(openProjectFile.exists());
    }

    @Test
    void testSaveFunc() throws FileNotFoundException, IOException {
        File saveFile = new File("save.xml");
        Save save = new Save();
        save.saveProject(saveFile);

        assertTrue(saveFile.exists());
    }

    @Test
    void testSaveAsFunc() throws FileNotFoundException, IOException {
        File saveAsFile = new File("saveAs.xml");
        SaveAs saveAs = new SaveAs();
        saveAs.saveProjectAs(saveAsFile);

        assertTrue(saveAsFile.exists());
    }

    @Test
    void testSaveAsPNGFunc() throws FileNotFoundException, IOException {
        File saveAsPNGFile = new File("saveAsPNG.png");
        SaveAsPNG saveAsPNG = new SaveAsPNG();
        saveAsPNG.saveProjectAsPNG(saveAsPNGFile);

        assertTrue(saveAsPNGFile.exists());
    }

    @Test
    void testImportFunc() throws FileNotFoundException, IOException {
        ImportProject importProject = new ImportProject();
        File importProjectFile = importProject.importProjectFile();

        assertTrue(importProjectFile.exists());
    }*/

    @Test
    void testExportFunc() throws FileNotFoundException, IOException, URISyntaxException {
        File xmlFile = new File("xmlforxsd.xml");
        xmlFile.createNewFile();

        PrintWriter f0 = new PrintWriter(new FileWriter(xmlFile));
        f0.println("This is a test file");
        f0.close();

        MenuBar menuBar = new MenuBar(null);
        menuBar.exportFunc();

        assertTrue(xmlFile.exists());

        Scanner in = new Scanner(xmlFile);
        String line = in.nextLine();
        assertEquals("This is a test file", line);

        in.close();
    }

    @Test
    void testManualFunc() throws IOException {
        File pdfTemp = null;
        MenuBar menuBar = new MenuBar(null);
        menuBar.manualFunc();

        assertTrue(Desktop.isDesktopSupported());

        // Open the PDF
        pdfTemp = new File("docs/manual.pdf");
        assertTrue(pdfTemp.exists());
    }

    @AfterEach
    void cleanup() {
        // Delete any files created during the tests
        File scenariosFile = new File("scenarios.json");
        if (scenariosFile.exists()) {
            scenariosFile.delete();
        }

        File saveFile = new File("save.xml");
        if (saveFile.exists()) {
            saveFile.delete();
        }

        File saveAsFile = new File("saveAs.xml");
        if (saveAsFile.exists()) {
            saveAsFile.delete();
        }

        File saveAsPNGFile = new File("saveAsPNG.png");
        if (saveAsPNGFile.exists()) {
            saveAsPNGFile.delete();
        }

        File xmlFile = new File("xmlforxsd.xml");
        if (xmlFile.exists()) {
            xmlFile.delete();
        }

        File pdfTemp = new File("docs/manual.pdf");
        if (pdfTemp.exists()) {
            pdfTemp.delete();
        }
    }
}