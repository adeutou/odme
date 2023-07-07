package odme.odmeeditor;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class VariableTest {
    @Test
    void testSetNullRowsToVariableTable() {
        Variable variable = new Variable();
        variable.setNullRowsToVariableTable();

        int rowCount = variable.getModel().getRowCount();
        assertEquals(100, rowCount);
    }

    @Test
    void testSetNullToAllRows() {
        Variable variable = new Variable();
        variable.setNullToAllRows();

        int rowCount = variable.getModel().getRowCount();
        assertEquals(100, rowCount);

        for (int i = 0; i < 100; i++) {
            String value = (String) variable.getModel().getValueAt(i, 0);
            assertEquals("", value);
        }
    }

    @Test
    void testShowNodeValuesInTable() {
        Variable variable = new Variable();
        String selectedNode = "selectedNode";
        String[] nodeVariables = {"variable1,string,value1", "variable2,integer,value2,10,20"};
        variable.showNodeValuesInTable(selectedNode, nodeVariables);

        int rowCount = variable.getModel().getRowCount();
        assertEquals(2, rowCount);

        String value1 = (String) variable.getModel().getValueAt(0, 0);
        assertEquals(selectedNode, value1);

        String value2 = (String) variable.getModel().getValueAt(1, 0);
        assertEquals(selectedNode, value2);
    }

    @Test
    void testUpdateTableData() {
        Variable variable = new Variable();
        String nodeName = "selectedNode";
        String variableName = "variable1";
        String variableType = "string";
        String variableValue = "value1";
        String variableLowerBound = "";
        String variableUpperBound = "";

        variable.updateTableData(nodeName, variableName, variableType, variableValue, variableLowerBound,
                variableUpperBound);

        String[] properties = {variableName, variableType, variableValue};
        assertEquals(properties, variable.getModel().getValueAt(0, 1));
    }

    @Test
    void testUpdateTableDataWithLowerBoundAndUpperBound() {
        Variable variable = new Variable();
        String nodeName = "selectedNode";
        String variableName = "variable1";
        String variableType = "int";
        String variableValue = "10";
        String variableLowerBound = "5";
        String variableUpperBound = "15";

        variable.updateTableData(nodeName, variableName, variableType, variableValue, variableLowerBound,
                variableUpperBound);

        String[] properties = {variableName, variableType, variableValue, variableLowerBound, variableUpperBound};
        assertEquals(properties, variable.getModel().getValueAt(0, 1));
    }

    @Test
    void testValueFieldvalidator() {
        Variable variable = new Variable();
        JTextField variableField = new JTextField("variable1");
        JTextField valueField = new JTextField("true");
        JLabel errorLabelField = new JLabel();
        JTextField lowerBoundField = new JTextField();
        JTextField upperBoundField = new JTextField();

        variable.valueFieldvalidator(variableField, valueField, errorLabelField, lowerBoundField, upperBoundField);
        assertFalse(errorLabelField.isVisible());

        valueField.setText("12345");
        variable.valueFieldvalidator(variableField, valueField, errorLabelField, lowerBoundField, upperBoundField);
        assertFalse(errorLabelField.isVisible());

        valueField.setText("abc");
        variable.valueFieldvalidator(variableField, valueField, errorLabelField, lowerBoundField, upperBoundField);
        assertTrue(errorLabelField.isVisible());
    }

    @Test
    void testLowerBoundFieldValidator() {
        Variable variable = new Variable();
        JTextField variableField = new JTextField("variable1");
        JTextField valueField = new JTextField("12345");
        JLabel errorLabelField = new JLabel();
        JTextField lowerBoundField = new JTextField();
        JTextField upperBoundField = new JTextField();

        lowerBoundField.setText("12346");
        variable.lowerBoundFieldValidator(variableField, valueField, errorLabelField, lowerBoundField, upperBoundField);
        assertTrue(errorLabelField.isVisible());

        lowerBoundField.setText("12345");
        variable.lowerBoundFieldValidator(variableField, valueField, errorLabelField, lowerBoundField, upperBoundField);
        assertFalse(errorLabelField.isVisible());
    }

    @Test
    void testUpperBoundFieldValidator() {
        Variable variable = new Variable();
        JTextField variableField = new JTextField("variable1");
        JTextField valueField = new JTextField("12345");
        JLabel errorLabelField = new JLabel();
        JTextField lowerBoundField = new JTextField();
        JTextField upperBoundField = new JTextField();

        upperBoundField.setText("12344");
        variable.upperBoundFieldValidator(variableField, valueField, errorLabelField, lowerBoundField, upperBoundField);
        assertTrue(errorLabelField.isVisible());

        upperBoundField.setText("12345");
        variable.upperBoundFieldValidator(variableField, valueField, errorLabelField, lowerBoundField, upperBoundField);
        assertFalse(errorLabelField.isVisible());
    }
}