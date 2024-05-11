import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryLevelOrderTraversal {
    Node root;
    public BinaryLevelOrderTraversal(){
        this.root=null;

    }
    public void insert(int val){
        root=insert(root,val);
    }
    public Node insert(Node root,int val){
        if(root==null){
            return new Node(val);
        }
        if(val<root.val){
            root.left=insert(root.left, val);
        }
        else if(val>root.val){
            root.right=insert(root.right, val);
        }
        return root;
    
    }

    public List<List<Integer>> level(Node root){
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> internal=new ArrayList<>();
            for(int i=0;i<size;i++){
                Node n=q.poll();
                internal.add(n.val);
                if(n.left!=null){
                    q.offer(n.left);
                }
                if(n.right!=null){
                    q.offer(n.right);

                }

            }
            result.add(0,internal);
        }
        return result;
    }
    public static void main(String[] args) {
        BinaryLevelOrderTraversal bst=new BinaryLevelOrderTraversal();
        int[] arr={10,3,5,20};
        for(int num: arr){
            bst.insert(num);
        }
        List<List<Integer>> ans=bst.level(bst.root);
        System.out.println(ans.toString());
    }

}
class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val=val;
        left=null;
        right=null;
    }
}