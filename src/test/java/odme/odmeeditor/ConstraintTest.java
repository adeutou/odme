package odme.odmeeditor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ConstraintTest {

    @Test
    void testShowConstraintsInTable() {
        Constraint constraint = new Constraint();
        String[] nodesToSelectedNode = {"Constraint1", "Constraint2", "Constraint3"};
        constraint.showConstraintsInTable(nodesToSelectedNode);
        assertEquals(3, constraint.model.getRowCount());
        assertEquals("Constraint1", constraint.model.getValueAt(0, 0));
        assertEquals("Constraint2", constraint.model.getValueAt(1, 0));
        assertEquals("Constraint3", constraint.model.getValueAt(2, 0));
    }

    /*@Test
    void testUpdateTableData() {
        Constraint constraint = new Constraint();
        String constraints = "Constraint1";
        constraint.updateTableData(constraints);
        assertEquals(1, constraint.model.getRowCount());
        assertEquals("Constraint1", constraint.model.getValueAt(0, 0));
    }*/

    @Test
    void testUpdateTableData() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Constraint constraint = new Constraint();
        String constraints = "Constraint1";

        /**
         * reflection is use to access the private updateTableData method in the Constraint class.
         * The getDeclaredMethod method is used to retrieve the private method, and setAccessible(true) is called
         * to override the method's access level. Finally, invoke is used to execute the private method with the
         * provided arguments.
         */

        // Access the private updateTableData method using reflection
        Method updateTableDataMethod = Constraint.class.getDeclaredMethod("updateTableData", String.class);
        updateTableDataMethod.setAccessible(true);

        // Invoke the private updateTableData method
        updateTableDataMethod.invoke(constraint, constraints);

        Assertions.assertEquals(1, constraint.model.getRowCount());
        Assertions.assertEquals("Constraint1", constraint.model.getValueAt(0, 0));
    }
}