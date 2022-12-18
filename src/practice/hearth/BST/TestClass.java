package practice.hearth.BST;

import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Node root = null;

        for (int i = 0; i < n; i++) {
            root = Node.insert(root, scanner.nextInt());
        }

        int subTreeRoot = scanner.nextInt();
        Node.preOrderTraversal(Node.search(root, subTreeRoot));
    }
}

class Node {
    int data;
    Node left, right;

    static Node insert(Node root, int data) {
        if (root == null) {
            Node node = new Node();
            node.data = data;
            root = node;
        } else {
            if (data < root.data)
                root.left = insert(root.left, data);
            else {
                if (data > root.data)
                    root.right = insert(root.right, data);
            }

        }
        return root;
    }

    static Node search(Node root, int data) {
        if (root == null)
            return null;
        else {
            if (root.data == data)
                return root;
            else {
                if (data < root.data)
                    return search(root.left, data);
                else
                    return search(root.right, data);
            }
        }
    }

    static void preOrderTraversal(Node root) {
        if (root == null)
            return;
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

}





