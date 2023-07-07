package odme.odmeeditor;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import javax.swing.tree.DefaultMutableTreeNode;
import java.lang.reflect.Field;

class ProjectTreeTest {

    @Test
    public void testAddModueFile() throws NoSuchFieldException, IllegalAccessException {
        ProjectTree projectTree = new ProjectTree();
        String fileName = "testFile";
        projectTree.addModueFile(fileName);
        DefaultMutableTreeNode addedModule = getPrivateField(projectTree, "addedModule");
        DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) addedModule.getChildAt(0);
        String childName = childNode.toString();
        assertEquals(fileName + ".xml", childName);
    }

    @Test
    public void testRemoveCurrentNode() throws NoSuchFieldException, IllegalAccessException {
        ProjectTree projectTree = new ProjectTree();
        String fileName = "testFile";
        projectTree.addModueFile(fileName);
        projectTree.removeCurrentNode();
        DefaultMutableTreeNode addedModule = getPrivateField(projectTree, "addedModule");
        int childCount = addedModule.getChildCount();
        assertEquals(0, childCount);
    }

    @Test
    public void testChangeCurrentProjectFileName() throws NoSuchFieldException, IllegalAccessException {
        ProjectTree projectTree = new ProjectTree();
        String fileName = "testFile";
        projectTree.addModueFile(fileName);
        projectTree.changeCurrentProjectFileName(fileName, "oldFileName");
        DefaultMutableTreeNode mainModule = getPrivateField(projectTree, "mainModule");
        DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) mainModule.getChildAt(0);
        String childName = childNode.toString();
        assertEquals(fileName + ".xml", childName);
    }

    /**
     * the getPrivateField() method uses reflection to access the private fields of the ProjectTree class.
     * It allows to retrieve the private fields addedModule and mainModule, and perform assertions on their values.
     */
    private <T> T getPrivateField(Object object, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return (T) field.get(object);
    }
}