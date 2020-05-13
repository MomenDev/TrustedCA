package test.algorithm.tree;

import algorithm.tree.TreeNode;
import algorithm.tree.TreeTraversalBfs;
import org.junit.Test;

/**
 * @author chenjian
 * @date 2020/05/14
 * description:
 **/
public class TreeTraversalBfsTest {

    @Test
    public void levelOrder() {
        TreeTraversalBfs traversalBfs = new TreeTraversalBfs();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        traversalBfs.levelOrder(root);
    }

}