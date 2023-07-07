package odme.jtreetograph;

import static org.junit.jupiter.api.Assertions.*;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;
import org.junit.jupiter.api.Test;

import java.io.File;

class JtreeToGraphSaveTest {

    @Test
    public void testSaveGraph() {
        // Create a graph.
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        // Add a node to the graph.
        mxCell node = (mxCell) graph.insertVertex(parent,null, "Node", 0, 0, 100, 100);

        // Save the graph to an XML file.
        JtreeToGraphSave.saveGraph();

        // Check that the file was saved successfully.
        File file = new File("ssdFileGraph.xml");
        assertEquals(true, file.exists());
    }

    @Test
    public void testSaveModuleFromCurrentModel() {
        // Create a graph.
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        // Add a node to the graph.
        mxCell node = (mxCell) graph.insertVertex(parent, null, "Node", 0, 0, 100, 100);

        // Save the module from the current model.
        JtreeToGraphSave.saveModuleFromCurrentModel(node);

        // Check that the module was saved successfully.
        assertEquals(1, JtreeToGraphVariables.treeSyncNodeCount);
    }

    @Test
    public void testSaveModuleFromCurrentModelAsXML() {
        // Create a graph.
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        // Add a node to the graph.
        mxCell node = (mxCell) graph.insertVertex(parent,null, "Node", 0, 0, 100, 100);

        // Save the module from the current model as XML.
        JtreeToGraphSave.saveModuleFromCurrentModelAsXML(node, "test");

        // Check that the XML file was saved successfully.
        File file = new File("test.xml");
        assertEquals(true, file.exists());
    }
}