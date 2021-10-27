package WhiteBox;

import BlackBox.CycleSort;
import Utils.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BinaryTreeSerializerTest {

    @Test
    public void basicTest() {
        BinaryTreeSerializer bs = new BinaryTreeSerializerImpl();
        TreeNode root = null;
        String ret = bs.serialize(root);
        assertEquals("[null]", ret);
        String s = "[null]";
        TreeNode rootret = bs.deserialize(s);
        assertEquals(null, rootret);
    }

    @Test
    public void level1Test() {
        BinaryTreeSerializer bs = new BinaryTreeSerializerImpl();
        TreeNode root = new TreeNode(0);
        String ret = bs.serialize(root);
        String s = "[0,null,null]";
        assertEquals(s, ret);
        TreeNode rootret = bs.deserialize(s);
        assertEquals(root, rootret);
    }

    @Test
    public void level2OneChildTest() {
        BinaryTreeSerializer bs = new BinaryTreeSerializerImpl();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        String ret = bs.serialize(root);
        String s = "[0,1,null,null,null]";
        assertEquals(s, ret);
        TreeNode rootret = bs.deserialize(s);
        assertEquals(root, rootret);
    }

    @Test
    public void level2Test() {
        BinaryTreeSerializer bs = new BinaryTreeSerializerImpl();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        String ret = bs.serialize(root);
        String s = "[0,1,2,null,null,null,null]";
        assertEquals(s, ret);
        TreeNode rootret = bs.deserialize(s);
        assertEquals(root, rootret);
    }

    @Test
    public void shortDeserializeTest() {
        BinaryTreeSerializer bs = new BinaryTreeSerializerImpl();
        String s = "";
        TreeNode rootret = bs.deserialize(s);
        assertEquals(null, rootret);
    }

}
