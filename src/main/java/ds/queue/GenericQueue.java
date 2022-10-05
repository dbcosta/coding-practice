package ds.queue;

import java.util.ArrayList;
import java.util.List;

public class GenericQueue<T> {
    private int front,rear;
    private final int size;
    private final List<T> queue;

    public GenericQueue(int size){
        front = rear = 0;
        this.size = size;
        queue = new ArrayList<>(size);
    }

    private void enqueue(T element){
        if(rear == size){
            System.out.println("Queue is full!");
        }else{
            queue.add(element);
            ++rear;
            System.out.println(queue);
            System.out.println("Element "+element+" has been added to the queue with capacity "+rear);
        }
    }

    private T dequeue(){
        if(front > rear){
            System.out.println("Queue is empty!");
            return null;
        }else{
            return queue.get(front++);
        }
    }

    private void printQueue(){
        System.out.println("Queue:");
        for(int i=front;i<rear;i++){
            System.out.print(queue.get(i)+" ");
        }
    }

    public static void main(String[] args) {
        GenericQueue<Integer> queue = new GenericQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        queue.printQueue();
    }
}
