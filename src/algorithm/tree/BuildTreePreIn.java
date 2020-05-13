package algorithm.tree;

import java.util.HashMap;

/**
 * @author chenjian
 * @date 2020/05/14
 * description:
 **/
public class BuildTreePreIn {
    HashMap<Integer, Integer> memo = new HashMap<>();
    int[] prevCopy;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            memo.put(inorder[i], i);
        }
        prevCopy = preorder;
        TreeNode root = buildTreeExe(0, prevCopy.length - 1, 0, inorder.length - 1);
        return root;
    }

    private TreeNode buildTreeExe(int pres, int pree, int ins, int ine) {
        if (pres > pree || ins > ine) {
            return null;
        }
        TreeNode root = new TreeNode(prevCopy[pres]);
        int inRoot = memo.get(root.val);
        root.left = buildTreeExe(pres + 1, pres + inRoot - ins, ins, inRoot - 1);
        root.right = buildTreeExe(pres + inRoot - ins + 1, pree, inRoot + 1, ine);
        return root;
    }
}
