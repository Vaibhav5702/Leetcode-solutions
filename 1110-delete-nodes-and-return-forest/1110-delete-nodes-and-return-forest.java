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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list=new ArrayList();
        if(root==null)
            return list;
        Set<Integer> set=new HashSet();
        for(int del:to_delete)
        {
            set.add(del);
        }
        dfs(root,list,set,true);
        return list;
    }
    public TreeNode dfs(TreeNode root,List<TreeNode> list,Set<Integer> set,boolean isRoot)
    {
        if(root==null)
            return null;
        TreeNode ret=root;
        if(!set.contains(root.val))
        {
            if(isRoot)
                list.add(root);
            isRoot=false;
        }
        else
        {
            ret=null;
            isRoot=true;
        }
        root.left=dfs(root.left,list,set,isRoot);
        root.right=dfs(root.right,list,set,isRoot);
        return ret;
    }
}