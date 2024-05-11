class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}

public class BSTPractice {
    Node root;
    public Node insertRecursive(Node root,int val){
        if(root==null){
            return new Node(val);
        }
        if(val<root.val){
            root.left=insertRecursive(root.left, val);
        }
        else {
            root.right=insertRecursive(root.right, val);
        }
        return root;
    }
    public void insert(int val){
        root=insertRecursive(root,val);
    }
    public Node delete(Node root,int key){
        if(root==null){
            return null;
        }
        if(key<root.val){
            root.left=delete(root.left, key);
        }
        else if(key>root.val){
            root.right=delete(root.right, key);
        }
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            root.val=minVal(root.right);
            root.right=delete(root.right, root.val);
        }
        return root;

    }
    public int minVal(Node root){
        int min=root.val;
        while(root.left!=null){
            min=root.left.val;
            root=root.left;
        }
        return min;
    }
    public void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.val+" ");
            inorder(root.right);
        }
    }
    public static void main(String[] args) {
        BSTPractice bst=new BSTPractice();
        bst.insert(50);
        bst.insert(60);
        bst.insert(65);
        bst.insert(70);
        // bst.inorder(bst.root);
        bst.root=bst.delete(bst.root, 50);
        bst.inorder(bst.root);
    }
}
