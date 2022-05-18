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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList();
        queue.offer(root);
        int depthSum=0;
        while(!queue.isEmpty())
        {
            int size=queue.size(),sum=0;
            for(int i=0;i<size;i++)
            {
                TreeNode node=queue.poll();
                sum+=node.val;
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            depthSum=sum;
        }
        return depthSum;
    }
}