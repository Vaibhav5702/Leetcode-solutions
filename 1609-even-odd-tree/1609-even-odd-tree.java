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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int level=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            if(level%2==0)
            {
                int max=-1;
                for(int i=0;i<size;i++)
                {
                    TreeNode node=q.poll();
                    
                    if(node.val%2==0||node.val<=max)
                        return false;
                    else
                        max=node.val;
                    if(node.left!=null)
                        q.offer(node.left);
                    if(node.right!=null)
                        q.offer(node.right);
                }
            }
            else
            {
                int min=Integer.MAX_VALUE;
                for(int i=0;i<size;i++)
                {
                    TreeNode node=q.poll();
                    if(node.val%2!=0||node.val>=min)
                        return false;
                    else
                        min=node.val;
                    if(node.left!=null)
                        q.offer(node.left);
                    if(node.right!=null)
                        q.offer(node.right);
                }
            }
            level++;
        }
        return true;
    }
}