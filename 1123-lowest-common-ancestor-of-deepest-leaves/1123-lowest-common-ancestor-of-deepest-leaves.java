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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Map<TreeNode,TreeNode> map=new HashMap();
        Queue<TreeNode> queue=new LinkedList();
        Set<TreeNode> nodes=new HashSet();
        queue.offer(root);
        map.put(root,root);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            nodes=new HashSet();
            for(int i=0;i<size;i++)
            {
                TreeNode node=queue.poll();
                nodes.add(node);
                if(node.left!=null)
                {
                    map.put(node.left,node);
                    queue.offer(node.left);
                }
                if(node.right!=null)
                {
                    map.put(node.right,node);
                    queue.offer(node.right);
                }
            }
        }
        List<TreeNode> upper=new ArrayList(nodes);
        while(nodes.size()!=1)
        {
            upper=new ArrayList();
            for(TreeNode node:nodes)
            {
                upper.add(map.get(node));
            }
            nodes=new HashSet(upper);
        }
        return upper.get(0);
    }
}