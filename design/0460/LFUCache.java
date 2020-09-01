import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Iterator;

class Node{
    int key;
    int value;
    int fre;

    public Node(){
        ;
    }

    public Node(int key,int value){
        this.key=key;
        this.value=value;
        this.fre=1;
    }
}

class LFUCache {

    int capacity;
    int size;
    int min;

    Map<Integer,Node> myHash;
    Map<Integer,LinkedHashSet<Node> > freqHash;

    void freqInc(Node node){
        int fre=node.fre;
        LinkedHashSet<Node> set=freqHash.get(fre);
        set.remove(node);
        if(fre==min&&set.size()==0){
            min=fre+1;
        }
        node.fre++;
        LinkedHashSet<Node> newSet=freqHash.get(fre+1);
        if(newSet==null){
            newSet=new LinkedHashSet<>();
            freqHash.put(fre+1,newSet);
        }
        newSet.add(node);
    }

    void addNode(Node node){
        LinkedHashSet<Node> set=freqHash.get(1);
        if(set==null){
            set=new LinkedHashSet<>();
            freqHash.put(1,set);
        }
        set.add(node);
        min=1;
    }

    Node removeNode(){
        LinkedHashSet<Node> set=freqHash.get(min);
        Iterator<Node> it=set.iterator();
        Node deadNode=it.next();
        set.remove(deadNode);
        return deadNode;
    }

    public int get(int key){
        Node node=myHash.get(key);
        if(node==null){
            return -1;
        }
        freqInc(node);
        return node.value;
    }

    public void put(int key,int value){
        if(capacity==0){
            return;
        }
        Node node=myHash.get(key);
        if(node!=null){
            node.value=value;
            freqInc(node);
        }else{
            if(size==capacity){
                Node deadNode=removeNode();
                myHash.remove(deadNode.key);
                size--;
            }
            Node newNode=new Node(key,value);
            myHash.put(key,newNode);
            addNode(newNode);
            size++;
        }
    }

    public LFUCache(int capacity){
        myHash=new HashMap<>(capacity);
        freqHash=new HashMap<>();
        this.capacity=capacity;
    }
}