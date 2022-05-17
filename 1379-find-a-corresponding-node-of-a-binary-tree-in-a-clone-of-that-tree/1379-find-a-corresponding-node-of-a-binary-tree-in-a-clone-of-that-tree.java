/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> org=new LinkedList();
        Queue<TreeNode> cl=new LinkedList();
        org.offer(original);
        cl.offer(cloned);
        while(!org.isEmpty())
        {
            int size=org.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node1=org.poll();
                TreeNode node2=cl.poll();
                if(target==node1)
                    return node2;
                if(node1.left!=null)
                {
                    org.offer(node1.left);
                    cl.offer(node2.left);
                }
                if(node1.right!=null)
                {
                    org.offer(node1.right);
                    cl.offer(node2.right);
                }
            }
        }
        return null;
    }
}