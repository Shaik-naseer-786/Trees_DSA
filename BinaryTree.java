import java.util.Scanner;

public class BinaryTree {
    public BinaryTree() {

    }

    private class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    // insert elements

    private void populate(Scanner sc) {
        System.out.println("Enter root node:");
        int val = sc.nextInt();
        root = new Node(val);
        populate(sc, root);
    }

    private void populate(Scanner sc, Node node) {
        System.out.println("Do you enter left of:" + node.val);
        boolean left = sc.nextBoolean();
        if (left) {
            System.out.println("Enter the value left of" + node.val);
            int val = sc.nextInt();
            node.left = new Node(val);
            populate(sc, node.left);
        }
        System.out.println("Do you want enter right of " + node.val);
        boolean right = sc.nextBoolean();

        if (right) {
            System.out.println("Enter value of right of" + node.val);
            int val = sc.nextInt();
            node.right = new Node(val);
            populate(sc, node.right);
        }

    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.println(node.val + " ");
            display(node.left);
            display(node.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(sc);
        tree.display();
    }
}