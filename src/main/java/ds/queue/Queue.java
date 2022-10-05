package ds.queue;

import java.util.Arrays;

public class Queue {

    private int rear,front;
    private final int size;
    private final int queue[];

    public Queue(int size){
        rear = front = 0;
        queue = new int[size];
        this.size=size;
    }

    private void enqueue(int element){
        if(size == rear){
            System.out.println("Queue is full!");
        }else{
            queue[rear++] = element;
            System.out.println(Arrays.toString(queue));
            System.out.println("Element "+element+" has been added to the queue with capacity "+rear);
        }
    }

    private int dequeue(){
        if(front > rear){
            System.out.println("Queue is empty!");
            return 0;
        }else{
            return queue[++front];
        }
    }

    private void printQueue(){
        System.out.println("Queue:");
        for(int i=front;i<rear;i++){
            System.out.print(queue[i]+" ");
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        queue.printQueue();
    }
}
