package odme.odmeeditor;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class PanelSplitorTest {

    @Test
    void testAddSplitor() {
        ProjectTree projectPanel = new ProjectTree();
        DynamicTree treePanel = new DynamicTree();
        GraphWindow graphWindow = new GraphWindow();
        Console console = new Console();
        Variable scenarioVariable = new Variable();
        Constraint scenarioConstraint = new Constraint();
        JTabbedPane tabbedPane = new JTabbedPane();

        PanelSplitor panelSplitor = new PanelSplitor();
        JSplitPane result = panelSplitor.addSplitor(projectPanel, treePanel, graphWindow, console, scenarioVariable,
                scenarioConstraint, tabbedPane);

        assertNotNull(result);
        assertEquals(JSplitPane.HORIZONTAL_SPLIT, result.getOrientation());
        assertEquals(1400, result.getDividerLocation());
        assertEquals(6, result.getDividerSize());
        assertNull(result.getBorder());
    }
}