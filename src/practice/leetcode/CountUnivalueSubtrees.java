///*
//package practice.leetcode;
//
//public class CountUnivalueSubtrees {
//    public static void main(String[] args) {
//        Node node = buildTestTree();
//
//        System.out.println(getUnivalueSubtrees(node));
//    }
//    private static int count=0;
//
//    private static int getUnivalueSubtrees(Node root){
//        helper(root);
//        return count;
//    }
//
//    private static boolean helper(Node node){
//        if(node == null)
//            return true;
//        boolean isLeftUnivalue = helper(node.left);
//        boolean isRightUnivalue = helper(node.right);
//
//        if(node.left != null && node.val != node.left.val)
//            isLeftUnivalue = false;
//
//        if(node.right != null && node.val != node.right.val)
//            isRightUnivalue = false;
//
//        boolean isUnivalue = isLeftUnivalue && isRightUnivalue;
//        if (isUnivalue)
//            count++;
//        return isUnivalue;
//    }
//
//    private static Node buildTestTree(){
//        Node root = new Node(5);
//
//        Node node1 = new Node(5);
//        Node node2 = new Node(5);
//        root.left=node1;
//        root.right=node2;
//        Node node3 = new Node(5);
//        Node node4 = new Node(5);
//        node1.left=node3;
//        node1.right=node4;
//        Node node5 = new Node(5);
//        node2.right = node5;
//
//        return root;
//    }
//}
//
//
//class Node{
//    int val;
//    Node left;
//    Node right;
//
//    public Node(int val){
//        this.val = val;
//    }
//}
//*/
