import java.util.List;
import java.util.Queue;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.LinkedList;

class Node{
    public int val;
    public List<Node> children;
    
    public Node(){

    }

    public Node(int _val){
        val=_val;
    }

    public Node(int _val,List<Node> _children){
        val=_val;
        children=_children;
    }
}

class Solution {
    public List<List<Integer> > levelOrder(Node root) {
        List<List<Integer> >  res=new ArrayList<List<Integer> >();
        List<Integer> lRes=new ArrayList<Integer>();
        Queue<Pair<Node,Integer> > myTree=new LinkedList<Pair<Node,Integer> >();
        int level=0;
        int size;
        if(root==null){
            return res;
        }
        myTree.offer(new Pair<>(root,0));
        Node pNode;
        int pLevel=0,i;
        while(!myTree.isEmpty()){
            Pair<Node,Integer> pPair=myTree.poll();
            pNode=pPair.getKey();
            pLevel=pPair.getValue();
            if(pLevel==level){
                lRes.add(pNode.val);
            }else{
                res.add(lRes);
                lRes=new ArrayList<Integer>();
                lRes.add(pNode.val);
                level++;
            }
            size=pNode.children.size();
            for(i=0;i<size;i++){
                myTree.offer(new Pair<>(pNode.children.get(i),pLevel+1));
            }
        }
        res.add(lRes);
        return res;
    }
}