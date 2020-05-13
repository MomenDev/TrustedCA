package algorithm.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenjian
 * @date 2020/05/13
 * description:
 **/
public class TreeTraversalDfs {

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> levelList = new LinkedList<List<Integer>>();
        orderDfs(root, levelList);
        return levelList;
    }

    public void orderDfs(TreeNode root, LinkedList<List<Integer>> levelList) {
        if (root == null) {
            return;
        }
        List<Integer> list = new LinkedList<>();
        if (levelList.size() <= 0) {
            list = new LinkedList<>();
        } else {
            list = levelList.removeFirst();
        }
        list.add(root.val);
        orderDfs(root.left, levelList);
        orderDfs(root.right, levelList);
        levelList.addFirst(list);
    }
}
