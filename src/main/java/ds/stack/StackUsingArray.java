package ds.stack;

/**
 * Program to create a stack using array implementation.
 */
public class StackUsingArray {

    public static final int MAX = 10;
    int arr[] = new int[MAX];
    int top;

    public StackUsingArray(){
        top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int element){
        if(top >= MAX){
            System.out.println("Stack overflow!");
        }else {
            arr[++top]=element;
            System.out.println("Pushed element: "+element+" into the stack.");
        }
    }

    public int pop(){
        if(top<0){
            System.out.println("Stack underflow!");
            return -1;
        }else {
            int x = arr[top--];
            System.out.println("Element popped is: "+x);
            return x;
        }
    }

    public int peek(){
        if(top <0){
            System.out.println("Stack underflow!");
            return 0;
        }else{
            int x = arr[top];
            System.out.println("Element at the top is: "+x);
            return x;
        }
    }

    public void print(){
        for(int i=top; i>-1; i--){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray();
        System.out.println("Stack empty: "+stack.isEmpty());
        stack.push(1);
        stack.push(10);
        stack.push(100);
        stack.print();
        stack.pop();
        stack.print();
        stack.peek();
    }
}
