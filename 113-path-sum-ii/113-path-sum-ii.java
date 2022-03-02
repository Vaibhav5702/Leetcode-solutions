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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list=new ArrayList();
        if(root==null)
            return list;
        getSum(root,new ArrayList(),list,targetSum);
        return list;
    }
    public void getSum(TreeNode root,List<Integer> path,List<List<Integer>> list,int sum)
    {
        if(root.left==null&&root.right==null)
        {
            if(sum==root.val)
            {
                path.add(root.val);
                list.add(new ArrayList(path));
                path.remove(path.size()-1);
            }
            return;
        }
        path.add(root.val);
        if(root.left!=null)
            getSum(root.left,path,list,sum-root.val);
        if(root.right!=null)
            getSum(root.right,path,list,sum-root.val);
        path.remove(path.size()-1);
    }
}