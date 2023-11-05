package practice.ds;

import java.util.Arrays;

public class Stack<T> {

    private int top = -1;

    private void push(T[] arr, T element){
        if(top>=arr.length-1){
            System.out.println("stack overflow!");
        }else {
            top++;
            arr[top] = element;
        }
    }

    private T pop(T[] arr){
        if(top<=-1){
            System.out.println("stack underflow!");
            return null;
        }else{
            return arr[top--];
        }
    }

    private void print(T[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        String[] arr = new String[5];
        stack.push(arr,"100");
        stack.push(arr,"200");
        stack.push(arr,"300");
        stack.push(arr,"400");
        stack.push(arr,"500");
        stack.push(arr,"600");
        stack.print(arr);

        System.out.println(stack.pop(arr));
        System.out.println(stack.pop(arr));
        System.out.println(stack.pop(arr));
        System.out.println(stack.pop(arr));
        System.out.println(stack.pop(arr));
        System.out.println(stack.pop(arr));
    }
}
