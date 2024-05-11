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

public class BSTPRAC {
    Node root;
    public BSTPRAC(){
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
        root=insertRecursive(root,val);
    }
    public void inorderT(Node root){
        if(root!=null){
           
            inorderT(root.left);
            System.out.print(root.val+" ");
            inorderT(root.right);
        }
    }
    public void preorderT(Node root){
        if(root!=null){
            System.out.print(root.val+" ");
            preorderT(root.left);
            
            preorderT(root.right);
        }
    }
    public void postorderT(Node root){
        if(root!=null){
            postorderT(root.left);
            postorderT(root.right);
            System.out.print(root.val+" ");
        }
    }
    public Node delete(Node root,int key){
        if(root==null){
            return null;
        }
        if(key<root.val){
            root.left=delete(root.left, key);
        }
        else if(key >root.val){
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
        if(root.left!=null){
            min=root.left.val;
            root=root.left;
        }
        return min;
    }
    public static void main(String[] args) {
        BSTPRAC bt=new BSTPRAC();
        bt.insert(10);
        bt.insert(4);
        bt.insert(5);
        bt.insert(20);
        bt.insert(6);
        bt.insert(15);
        bt.insert(2);
        bt.insert(1);
        bt.insert(3);
        System.out.println("inorder:");
        bt.inorderT(bt.root);
        System.out.println();
        System.out.println("preoder:");
        bt.preorderT(bt.root);
        System.out.println();
        System.out.println("postorder:");
        bt.postorderT(bt.root);
        bt.delete(bt.root, 4);
        System.out.println();
        System.out.println("After deleting:");
        System.out.println("inorder:");
        bt.inorderT(bt.root);
        System.out.println();
        System.out.println("preoder:");
        bt.preorderT(bt.root);
        System.out.println();
        System.out.println("postorder:");
        bt.postorderT(bt.root);
    }
    
}
