package algorithm.tree;

import java.util.HashMap;

/**
 * @author chenjian
 * @date 2020/05/14
 * description:
 **/
public class BuildTree {
    HashMap<Integer, Integer> memo = new HashMap<>();
    int[] postCopy;

    public TreeNode buildTreeInPostExe(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            memo.put(inorder[i], i);
        }
        postCopy = postorder;
        TreeNode root = buildTreeInPostExe(0, inorder.length - 1, 0, postCopy.length - 1);
        return root;
    }

    private TreeNode buildTreeInPostExe(int ins, int ine, int posts, int poste) {
        if (ine < ins || poste < posts) {
            return null;
        }

        TreeNode node = new TreeNode(postCopy[poste]);
        int inRoot = memo.get(node.val);

        node.left = buildTreeInPostExe(ins, inRoot - 1, posts, posts + inRoot - ins - 1);
        node.right = buildTreeInPostExe(inRoot + 1, ine, posts + inRoot - ins, poste - 1);
        return node;
    }
}
