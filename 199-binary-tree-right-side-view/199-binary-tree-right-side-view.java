/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList();
        if(root==null)
            return list;
        Queue<TreeNode> queue=new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            TreeNode pop=null;
            for(int i=0;i<size;i++)
            {
                pop=queue.poll();
                if(pop.left!=null)
                    queue.offer(pop.left);
                if(pop.right!=null)
                    queue.offer(pop.right);
            }
            list.add(pop.val);
        }
        return list;
    }
}