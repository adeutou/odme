package odme.jtreetograph;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class JtreeToGraphVariablesTest {

    @Test
    public void testNodeNumber() {
        // The nodeNumber should be 1 initially.
        assertEquals(1, JtreeToGraphVariables.nodeNumber);

        // Increase the nodeNumber by 1.
        JtreeToGraphVariables.nodeNumber++;

        // The nodeNumber should be 2 now.
        assertEquals(2, JtreeToGraphVariables.nodeNumber);
    }

    @Test
    public void testPathToRoot() {
        // The pathToRoot should be empty initially.
        assertEquals(0, JtreeToGraphVariables.pathToRoot.size());

        // Add a node to the pathToRoot.
        JtreeToGraphVariables.pathToRoot.add("Node1");

        // The pathToRoot should now have 1 element.
        assertEquals(1, JtreeToGraphVariables.pathToRoot.size());
    }

    @Test
    public void testTreeSyncNodeCount() {
        // The treeSyncNodeCount should be 0 initially.
        assertEquals(0, JtreeToGraphVariables.treeSyncNodeCount);

        // Increase the treeSyncNodeCount by 1.
        JtreeToGraphVariables.treeSyncNodeCount++;

        // The treeSyncNodeCount should be 1 now.
        assertEquals(1, JtreeToGraphVariables.treeSyncNodeCount);
    }

    @Test
    public void testAddedCellNameSync() {
        // The addedCellNameSync should be null initially.
        assertEquals(null, JtreeToGraphVariables.addedCellNameSync);

        // Set the addedCellNameSync to "Node1".
        JtreeToGraphVariables.addedCellNameSync = "Node1";

        // The addedCellNameSync should now be "Node1".
        assertEquals("Node1", JtreeToGraphVariables.addedCellNameSync);
    }

    @Test
    public void testNotEquals() {
        // The nodeNumber should not be equal to 2.
        assertNotEquals(2, JtreeToGraphVariables.nodeNumber);
    }
}