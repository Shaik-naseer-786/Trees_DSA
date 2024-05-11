class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val=val;
    }
}
public class BST {
    Node root;
    public BST(){
        this.root=null;
    }
    public Node insertRecursive(Node root,int val){
        if(root==null){
            return new Node(val);
        }
        if(val<root.val){
            root.left=insertRecursive(root.left, val);
        }
        else if(val>root.val){
            root.right=insertRecursive(root.right, val);
        }
        return root;

    }
    public void insert(int val){
        root=insertRecursive(root, val);
    }
    public void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.val+" ");
            inorder(root.right);
        }
    }


    public void display(){
        
        System.out.println();
    }
    public static void main(String[] args) {
        BST bb=new BST();
        bb.insert(50);
        bb.insert(30);
        bb.insert(70);
        bb.insert(20);
        bb.insert(40);
        bb.insert(60);
        bb.insert(80);
        bb.inorder(bb.root);
    }
}
