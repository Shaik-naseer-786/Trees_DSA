import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BSTLevelorder {
    Node root;

    public BSTLevelorder() {
        this.root = null;
    }

    public void insert(int val) {
        root = insertR(root, val);
    }

    public Node insertR(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.val) {
            root.left = insertR(root.left, val);
        } else if (val > root.val) {
            root.right = insertR(root.right, val);
        }
        return root;
    }

    public List<Integer> levelorder(Node root) {
        List<Integer> result = new LinkedList<>();
        if (root == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result.add(0,node.val);

            if (node.left != null)
                queue.offer(node.left);

            if (node.right != null)
                queue.offer(node.right);
        }

        return result;
    }

    public static void main(String[] args) {
        BSTLevelorder bst = new BSTLevelorder();
        bst.insert(10);
        bst.insert(20);
        bst.insert(4);
        bst.insert(5);
        bst.insert(6);
        bst.insert(3);
        bst.insert(2);
        bst.insert(1);
        List<Integer> ans = bst.levelorder(bst.root);
        System.out.println(ans.toString());

    }
}
