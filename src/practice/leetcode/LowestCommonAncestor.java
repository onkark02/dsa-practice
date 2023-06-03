package practice.leetcode;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node0 = new TreeNode(0);
        TreeNode node3 = new TreeNode(3);
        TreeNode node8 = new TreeNode(8);
        root.left = node2;
        root.right = node8;
        node2.left = node0;
        node2.right = node4;
        node4.left = node3;
        System.out.println(new LowestCommonAncestor().lowestCommonAncestor(root,node2,node4).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int small = Math.min(p.val, q.val);
        int large = Math.max(p.val, q.val);
        while (root != null) {
            if (root.val > large) // p, q belong to the left subtree
                root = root.left;
            else if (root.val < small) // p, q belong to the right subtree
                root = root.right;
            else // Now, small <= root.val <= large -> This root is the LCA between p and q
                return root;
        }
        return null;
    }
}

class TreeNode {
    int val;
   TreeNode left;
   TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val,TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}