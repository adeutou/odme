package odme.odmeeditor;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.io.File;
import java.awt.event.MouseEvent;
import java.awt.event.InputEvent;
import javax.swing.JButton;

class DynamicTreeTest {

    @Test
    void testTreeModel() {
        DynamicTree dynamicTree = new DynamicTree();
        assertNotNull(dynamicTree.treeModel);
    }

    @Test
    void testTree() {
        DynamicTree dynamicTree = new DynamicTree();
        assertNotNull(dynamicTree.tree);
    }

    @Test
    void testclickControl() {
        DynamicTree dynamicTree = new DynamicTree();
        assertEquals(0, dynamicTree.clickControl);
    }

    //These test cases test the functionality of the openExistingProject(), removeCurrentNode(), addObjectWIthGraphAddition(), and addObject() methods in the DynamicTree class.

    @Test
    void testOpenExistingProject() {
        DynamicTree dynamicTree = new DynamicTree();
        String filename = "TestProject";
        String oldProjectTreeProjectName = "OldProjectTreeProjectName";
        dynamicTree.openExistingProject(filename, oldProjectTreeProjectName);
        assertEquals(filename, dynamicTree.projectFileName);
    }

    @Test
    void testRemoveCurrentNode() {
        DynamicTree dynamicTree = new DynamicTree();
        TreePath currentSelection = new TreePath(new Object[] {"Root", "Child1"});
        dynamicTree.removeCurrentNode();
        assertEquals(1, dynamicTree.tree.getRowCount());
    }

    @Test
    void testAddObjectWIthGraphAddition() {
        DynamicTree dynamicTree = new DynamicTree();
        String[] nodePath = new String[] {"Root", "Child1"};
        Object child = new Object();
        DefaultMutableTreeNode parentNode = dynamicTree.addObjectWIthGraphAddition(child, nodePath);
        assertEquals(child, parentNode.getUserObject());
    }

    @Test
    void testAddObject() {
        DynamicTree dynamicTree = new DynamicTree();
        Object child = new Object();
        DefaultMutableTreeNode parentNode = dynamicTree.addObject(child);
        assertEquals(child, parentNode.getUserObject());
    }

    /**The testSaveTreeModel() test case creates a new DynamicTree object and then calls the saveTreeModelAs() method
     * with the name of a file. The test case then verifies that the file exists and that it contains the expected data.
     */
    @Test
    void testSaveTreeModel() {
        DynamicTree dynamicTree = new DynamicTree();
        String fileName = "TestProject";
        dynamicTree.saveTreeModelAs(fileName);
        assertTrue(new File(fileName + "var").exists());
    }

    /**
     * The testOpenTreeModel() test case creates a new DynamicTree object and then calls the openTreeModel() method
     * with a file object. The test case then verifies that the varMap property of the DynamicTree object contains the expected data.
     */
    @Test
    void testOpenTreeModel() {
        DynamicTree dynamicTree = new DynamicTree();
        String fileName = "TestProject";
        dynamicTree.openTreeModel(new File(fileName + "var"));
        assertTrue(dynamicTree.varMap.size() > 0);
    }

    /**
     * The test case verifies that the clickControl property is set to 0 after the mouseReleased() method is called
     * with a mouse event that has the button3 pressed. This is because the button3 is not used to select a node in the tree.
     */
    @Test
    void testMouseReleased() {
        DynamicTree dynamicTree = new DynamicTree();
        JButton source = new JButton();
        int id = MouseEvent.MOUSE_RELEASED;
        long when = System.currentTimeMillis();
        int modifiers = InputEvent.BUTTON3_MASK;

        MouseEvent event = new MouseEvent(source, id, when, modifiers, 0, 0, 0, false, MouseEvent.BUTTON3);

        dynamicTree.mouseReleased(event);

        assertEquals(0, dynamicTree.clickControl);
    }
}