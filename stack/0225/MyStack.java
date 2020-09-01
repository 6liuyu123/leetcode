import java.util.LinkedList;
import java.util.Queue;

class MyStack{

    Queue<Integer> myQueue;
    Queue<Integer> temp;

    public MyStack(){
        myQueue=new LinkedList<Integer>();
        temp=new LinkedList<Integer>();
    }

    public void push(int x){
        while(!myQueue.isEmpty()){
            temp.offer(myQueue.poll());
        }
        myQueue.offer(x);
        while(!temp.isEmpty()){
            myQueue.offer(temp.poll());
        }
    }

    public int pop(){
        return (int)myQueue.poll();
    }

    public int top(){
        return (int)myQueue.element();
    }

    public boolean empty(){
        return myQueue.isEmpty();
    }
}