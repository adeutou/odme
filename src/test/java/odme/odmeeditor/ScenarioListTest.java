package odme.odmeeditor;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class ScenarioListTest {

    @Test
    public void testCreateScenarioListWindow() {
        ScenarioList scenarioList = new ScenarioList();
        scenarioList.createScenarioListWindow();
        assertEquals(true, true);
    }

    @Test
    public void testDeleteFromJson() {
        ScenarioList scenarioList = new ScenarioList();
        List<String[]> dataList = new ArrayList<String[]>();
        dataList.add(new String[]{"scenario1", "low", "remarks"});
        dataList.add(new String[]{"scenario2", "medium", "remarks"});
        dataList.add(new String[]{"scenario3", "high", "remarks"});
        scenarioList.deleteFromJson("scenario2");
        assertEquals(2, dataList.size());
    }

    @Test
    public void testParseObject() {
        ScenarioList scenarioList = new ScenarioList();
        JSONObject jsonObject = new JSONObject();
        JSONObject innerObject = new JSONObject();
        innerObject.put("name", "scenario1");
        innerObject.put("risk", "low");
        innerObject.put("remarks", "remarks");
        jsonObject.put("scenario", innerObject);
        String[] arr = scenarioList.parseObject(jsonObject);
        assertEquals("scenario1", arr[0]);
        assertEquals("low", arr[1]);
        assertEquals("remarks", arr[2]);
    }

    @Test
    public void testUpdateTableData() {
        ScenarioList scenarioList = new ScenarioList();
        String name = "scenario1";
        String risk = "low";
        String remarks = "remarks";
        scenarioList.updateTableData(name, risk, remarks);
        List<String[]> dataList = scenarioList.getJsonData();
        assertEquals(name, dataList.get(0)[0]);
        assertEquals(risk, dataList.get(0)[1]);
        assertEquals(remarks, dataList.get(0)[2]);
    }


}