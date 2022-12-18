package practice.leetcode;

public class KthSmallest {
    int val=-1;
    int count;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return val;
    }

    private void inorder(TreeNode root){
        if(root.left != null && count > 0){
            inorder(root.left);
        }

        if(count > 0){
            count--;
            if(count == 0){
                val = root.val;
                return;
            }
        }

        if(root.right != null && count > 0){
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1,null,node2);
        TreeNode node3 = new TreeNode(3,node1,node4);
        System.out.println(new KthSmallest().kthSmallest(node3,5));
    }


    static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
}
