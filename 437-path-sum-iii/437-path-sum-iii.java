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
    int count=0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer,Integer> map=new HashMap();
        map.put(0,1);
        countPaths(root,0,targetSum,map);
        return count;
    }
    public void countPaths(TreeNode root, int sum, int target,Map<Integer,Integer> map)
    {
        if(root==null)
            return;
        sum+=root.val;
        if(map.containsKey(sum-target))
            count+=map.get(sum-target);
        map.put(sum,map.getOrDefault(sum,0)+1);
        countPaths(root.left,sum,target,map);
        countPaths(root.right,sum,target,map);
        map.put(sum,map.get(sum)-1);
    }
}