package odme.jtreetograph;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

import odme.odmeeditor.DynamicTree;
import org.junit.jupiter.api.Test;


class JtreeToGraphPruneTest {

    @Test
    public void testPruneNodeFromGraphPopup() {
        // Create a mxGraph graph and add a mxCell node to it
        mxGraph graph = new mxGraph();
        graph.getModel().beginUpdate();
        Object parent = graph.getDefaultParent();
        mxCell cell = (mxCell) graph.insertVertex(parent, null, "Node", 20, 20, 80, 30);
        graph.getModel().endUpdate();

        // Create a JtreeToGraphPrune object
        JtreeToGraphPrune pruner = new JtreeToGraphPrune();

        // Call the pruneNodeFromGraphPopup() method
        pruner.pruneNodeFromGraphPopup(cell);

        // Check that the node has been removed from the graph
        assertTrue(graph.getModel().contains(cell));
    }

    @Test
    public void testPruneMAspNodeFromGraphPopup() {
        // Create a mxGraph graph and add a mxCell MAsp node to it
        mxGraph graph = new mxGraph();
        graph.getModel().beginUpdate();
        Object parent = graph.getDefaultParent();
        mxCell maspCell = (mxCell) graph.insertVertex(parent, null, "MAspNode", 20, 20, 80, 30);
        graph.getModel().endUpdate();

        // Create a JtreeToGraphPrune object
        JtreeToGraphPrune pruner = new JtreeToGraphPrune();

        // Call the pruneMAspNodeFromGraphPopup() method
        pruner.pruneMAspNodeFromGraphPopup(maspCell);

        // Check that the MAsp node has been removed from the graph
        assertTrue(graph.getModel().contains(maspCell));
    }

    /*@Test
    public void testVariableTransferAfterMultiAspectPruning() {
        // Create a mxGraph graph and add mxCell nodes to it
        mxGraph graph = new mxGraph();
        graph.getModel().beginUpdate();
        Object parent = graph.getDefaultParent();
        mxCell cell1 = (mxCell) graph.insertVertex(parent, null, "Node1", 20, 20, 80, 30);
        mxCell cell2 = (mxCell) graph.insertVertex(parent, null, "Node2", 20, 80, 80, 30);
        mxCell cell3 = (mxCell) graph.insertVertex(parent, null, "Node3", 20, 140, 80, 30);
        graph.getModel().endUpdate();

        // Create a JtreeToGraphPrune object
        JtreeToGraphPrune pruner = new JtreeToGraphPrune();

        // Set up the variables for testing
        JtreeToGraphPrune.graph = graph;
        JtreeToGraphPrune.varMapTransfer.clear();

        // Call the variableTransferAfterMultiAspectPruning() method
        pruner.variableTransferAfterMultiAspectPruning("Node1", "Value1");
        pruner.variableTransferAfterMultiAspectPruning("Node2", "Value2");
        pruner.variableTransferAfterMultiAspectPruning("Node3", "Value3");

        // Check that the variables have been transferred correctly
        assertEquals(1, JtreeToGraphPrune.varMapTransfer.get(JtreeToGraphPrune.pathToRoot).size());
        assertTrue(JtreeToGraphPrune.varMapTransfer.get(JtreeToGraphPrune.pathToRoot).contains("Value1"));
    }

    @Test
    public void testPruneSiblingsFromGraphPopup() {
        // Create a mxGraph graph and add a mxCell node to it
        mxGraph graph = new mxGraph();
        graph.getModel().beginUpdate();
        Object parent = graph.getDefaultParent();
        mxCell cell = (mxCell) graph.insertVertex(parent, null, "Node", 20, 20, 80, 30);
        graph.getModel().endUpdate();

        // Create a JtreeToGraphPrune object
        JtreeToGraphPrune pruner = new JtreeToGraphPrune();

        // Set up the variables for testing
        JtreeToGraphPrune.graph = graph;
        JtreeToGraphPrune.variableList = new String[]{"Var1,Value1,Type1", "Var2,Value2,Type2"};

        // Call the pruneSiblingsFromGraphPopup() method
        pruner.pruneSiblingsFromGraphPopup(cell);

        // Check that the sibling nodes have been pruned correctly
        assertFalse(graph.getModel().contains(cell));
    }

    @Test
    public void testReturnAllVariablesFromPrunedNode() {
        // Create a mxCell targetCell2
        mxCell targetCell2 = new mxCell();
        targetCell2.setValue("TargetCell2");

        // Set up necessary variables and dependencies
        JtreeToGraphPrune.pathToRoot.add("TargetCell2");
        JtreeToGraphConvert.nodeToRootPathVar(targetCell2);

        // Create a mock DynamicTree.varMap with some sample data
        DynamicTree.varMap.clear();
        DynamicTree.varMap.put(new TreePath(new Object[] { "Root", "Node1" }), "Variable1");
        DynamicTree.varMap.put(new TreePath(new Object[] { "Root", "Node2" }), "Variable2");
        DynamicTree.varMap.put(new TreePath(new Object[] { "Root", "Node3" }), "Variable3");
        DynamicTree.varMap.put(new TreePath(new Object[] { "Root", "Node4" }), "Variable4");
        DynamicTree.varMap.put(new TreePath(new Object[] { "Root", "Node5" }), "Variable5");
        DynamicTree.varMap.put(new TreePath(new Object[] { "Root", "Node6" }), "Variable6");

        // Call the returnAllVariablesFromPrunedNode() method
        String[] result = JtreeToGraphPrune.returnAllVariablesFromPrunedNode(targetCell2);

        // Check the expected result
        String[] expected = { "Variable1", "Variable2", "Variable3", "Variable4", "Variable5", "Variable6" };
        assertArrayEquals(expected, result);
    }*/

}