package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by prateek on 28/05/17.
 */
public class LevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(a);
        queue.add(null);
        ArrayList<Integer> row = new ArrayList<Integer>();
        while(!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            if(curr == null) {
                res.add(row);
                row = new ArrayList<Integer>();
                if(!queue.isEmpty())
                    queue.add(null);
            } else{
                row.add(curr.val);
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
        }
        return res;
    }
}

