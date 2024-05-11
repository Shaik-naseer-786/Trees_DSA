import java.util.ArrayList;
import java.util.List;

class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val=val;
    }
}
public class InorderTraversal {
    Node root;
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

    public List<Integer> inorder(Node root){
        List<Integer> result=new ArrayList<>();
        helper(root,result);
        return result;
    }
    private void helper(Node root,List<Integer> result){
        if(root!=null){
            helper(root.left,result);
            result.add(root.val);
            helper(root.right, result);
        }
    }
    public static void main(String[] args) {
        InorderTraversal it=new InorderTraversal();
        it.insert(1);
        it.insert(2);
        it.insert(3);
        List<Integer> ans=new ArrayList<>();
        ans=it.inorder(it.root);
        System.out.println(ans.toString());
        
    }
}
