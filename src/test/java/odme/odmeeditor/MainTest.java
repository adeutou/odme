package odme.odmeeditor;

import static org.junit.jupiter.api.Assertions.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class MainTest {

    @Test
    void testCreateScenariosJson() throws IOException {
        File scenariosFile = new File(ODMEEditor.fileLocation + "/" + ODMEEditor.projName + "/scenarios.json");
        assertFalse(scenariosFile.exists());

        Main.createScenariosJson();

        assertTrue(scenariosFile.exists());

        FileWriter file = new FileWriter(scenariosFile);
        JSONArray data = new JSONArray();
        JSONObject jo = new JSONObject();
        jo.put("name", "InitScenario");
        jo.put("risk", "");
        jo.put("remarks", "");

        JSONObject jom = new JSONObject();
        jom.put("scenario", jo);
        data.add(jom);

        file.write(data.toJSONString());
        file.close();

        JSONObject scenarioObj = (JSONObject) ((JSONObject) data.get(0)).get("scenario");
        assertEquals("InitScenario", scenarioObj.get("name"));
    }

}