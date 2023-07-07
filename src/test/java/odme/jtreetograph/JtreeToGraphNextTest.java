package odme.jtreetograph;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.mxgraph.model.mxCell;

class JtreeToGraphNextTest {

    @Test
    public void testNextChildNodeForVariable() {
        // Create a test graph.
        mxCell cell = new mxCell();
        cell.setValue("Test");

        // Call the `nextChildNodeForVariable()` method.
        JtreeToGraphNext.nextChildNodeForVariable(cell);

        // Assert that the value of the cell has been updated.
        assertEquals("TestSpec", cell.getValue());
    }

    @Test
    public void testNextChild() {
        // Create a test graph.
        mxCell cell = new mxCell();
        cell.setValue("Test");

        // Call the `nextChild()` method.
        JtreeToGraphNext.nextChild(cell);

        // Assert that the value of the cell has been updated.
        assertEquals("TestDec", cell.getValue());
    }

    @Test
    public void testNextChildNodeInPath() {
        // Create a test graph.
        mxCell cell = new mxCell();
        cell.setValue("Test");

        // Call the `nextChildNodeInPath()` method.
        JtreeToGraphNext.nextChildNodeInPath(cell);

        // Assert that the value of the cell has not been updated.
        assertEquals("Test", cell.getValue());
    }

    @Test
    public void testNextChildNodeForcheckSubtreeNode() {
        // Create a test graph.
        mxCell cell = new mxCell();
        cell.setValue("Test");

        // Call the `nextChildNodeForcheckSubtreeNode()` method.
        JtreeToGraphNext.nextChildNodeForcheckSubtreeNode(cell);

        // Assert that the value of the cell has not been updated.
        assertEquals("Test", cell.getValue());
    }

    @Test
    public void testNextChildNodeForcheckSubtreeNodeSync() {
        // Create a test graph.
        mxCell cell = new mxCell();
        cell.setValue("Test");

        // Call the `nextChildNodeForcheckSubtreeNodeSync()` method.
        JtreeToGraphNext.nextChildNodeForcheckSubtreeNodeSync(cell);

        // Assert that the value of the cell has not been updated.
        assertEquals("Test", cell.getValue());
    }

    @Test
    public void testNextChildNodeForcheckSubtreeNodeSyncDelete() {
        // Create a test graph.
        mxCell cell = new mxCell();
        cell.setValue("Test");

        // Call the `nextChildNodeForcheckSubtreeNodeSyncDelete()` method.
        JtreeToGraphNext.nextChildNodeForcheckSubtreeNodeSyncDelete(cell);

        // Assert that the value of the cell has not been updated.
        assertEquals("Test", cell.getValue());
    }

    @Test
    public void testNextChildNodeForcheckSubtreeNodeSyncRename() {
        // Create a test graph.
        mxCell cell = new mxCell();
        cell.setValue("Test");

        // Call the `nextChildNodeForcheckSubtreeNodeSyncRename()` method.
        JtreeToGraphNext.nextChildNodeForcheckSubtreeNodeSyncRename(cell, "NewName");

        // Assert that the value of the cell has not been updated.
        assertEquals("Test", cell.getValue());
    }

}