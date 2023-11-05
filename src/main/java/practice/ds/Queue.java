package practice.ds;

import java.util.Arrays;

public class Queue {

    private final int[] arr = new int[5];
    private int rear=-1,front=-1;

    private void enqueue(int element){
        if(rear>=arr.length-1){
            System.out.println("Queue is full!");
        }else{
            arr[++rear]=element;
        }
    }

    private int dequeue(){
        if(rear==front){
            System.out.println("Queue is empty!");
            return -1;
        }else{
            return arr[++front];
        }
    }

    private void print(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.print(queue.arr);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
