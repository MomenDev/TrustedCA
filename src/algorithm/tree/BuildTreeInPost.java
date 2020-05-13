package algorithm.tree;

import java.util.HashMap;

/**
 * @author chenjian
 * @date 2020/05/14
 * description:
 **/
public class BuildTreeInPost {
    HashMap<Integer, Integer> memo = new HashMap<>();
    int[] postCopy;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            memo.put(inorder[i], i);
        }
        postCopy = postorder;
        TreeNode root = buildTreeExe(0, inorder.length - 1, 0, postCopy.length - 1);
        return root;
    }

    private TreeNode buildTreeExe(int ins, int ine, int posts, int poste) {
        if (ine < ins || poste < posts) {
            return null;
        }

        TreeNode node = new TreeNode(postCopy[poste]);
        int inRoot = memo.get(node.val);

        node.left = buildTreeExe(ins, inRoot - 1, posts, posts + inRoot - ins - 1);
        node.right = buildTreeExe(inRoot + 1, ine, posts + inRoot - ins, poste - 1);
        return node;
    }
}
