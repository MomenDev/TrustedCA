package algorithm.tree;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenjian
 * @date 2020/05/13
 * description:
 **/
public class TreeTraversalBfs {

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> levelList = new LinkedList<List<Integer>>();
        if (root == null) {
            return levelList;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        LinkedList<Integer> tempList = new LinkedList<>();
        deque.add(root);
        deque.add(null);
        while (deque.size() > 0) {
            TreeNode node = deque.poll();
            if (node == null && deque.size() > 0) {
                levelList.addLast(tempList);
                tempList = new LinkedList<>();
                deque.add(null);
                continue;
            } else if (node == null) {
                continue;
            }
            tempList.add(node.val);
            if (node.left != null) {
                deque.add(node.left);
            }
            if (node.right != null) {
                deque.add(node.right);
            }
        }
        levelList.addLast(tempList);
        return levelList;
    }

}
