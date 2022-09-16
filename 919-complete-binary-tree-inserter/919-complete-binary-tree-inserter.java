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
class CBTInserter {

    Queue<TreeNode> q;
    TreeNode root;
    public CBTInserter(TreeNode root) {
        q=new LinkedList<>();
        this.root=root;
        q.offer(root);
        while(true)
        {
            TreeNode p=q.peek();
            if(p.left!=null)
                q.offer(p.left);
            else
                break;
            if(p.right!=null)
                q.offer(p.right);
            else
                break;
            q.poll();
        }
    }
    
    public int insert(int val) {
        TreeNode node=q.peek();
        if(node.left==null){
            node.left=new TreeNode(val);
            q.offer(node.left);
            return node.val;
        }
        node.right=new TreeNode(val);
        q.offer(node.right);
        q.poll();
        return node.val;
        
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */