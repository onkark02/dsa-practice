package practice.leetcode;

public class ConnectNextNode {
    public static void main(String[] args) {
        ConnectNextNode connectNextNode = new ConnectNextNode();
        Node testNode = createTestNode();
    }

    private static Node createTestNode(){
        Node node = new Node();

        return node;
    }

    public Node connect(Node root) {
        if(root == null)
            return null;

        if(root.left != null){
            if(root.right != null){
                root.left.next = root.right;
            }else{
                root.left.next = getNextNode(root);
            }
        }
        if(root.right != null){
            root.right.next = getNextNode(root);
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    private Node getNextNode(Node root){
        Node next = null;
        Node curr = root;
        while(curr != null && curr.next != null){
            if(curr.next.left != null)
                next = curr.next.left;
            else if(curr.next.right != null)
                next = curr.next.right;
            curr = curr.next;
            if(next != null)
                break;
        }
        return next;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
