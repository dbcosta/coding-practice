package ds.stack;

import java.util.ArrayList;
import java.util.List;

public class GenericStack<T> {

    public static final int MAX = 10;
    int top;
    List<T> elements = new ArrayList<>(MAX);

    GenericStack(){
        top = -1;
    }

    public static void main(String[] args) {
        GenericStack<String> genericStack = new GenericStack();
        System.out.println("Stack empty: " + genericStack.isEmpty());
        genericStack.push("java");
        genericStack.push("js");
        genericStack.push("python");
        genericStack.print();
        System.out.println("Popped element: " + genericStack.pop());
        System.out.println("Element at the top is: " + genericStack.peek());
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public void push(T data) {
        if (top >= MAX) {
            System.out.println("Stack overflow!");
        } else {
            elements.add(data);
            ++top;
            System.out.println("Pushed element " + data + " into the stack.");
        }
    }

    public T pop() {
        if (top < 0) {
            System.out.println("Stack underflow!");
            return null;
        } else {
            return elements.get(top--);
        }
    }

    public T peek() {
        if (top < 0) {
            System.out.println("Stack underflow!");
            return null;
        } else {
            return elements.get(top);
        }
    }

    public void print() {
        for (int i = top; i > -1; i--) {
            System.out.println(elements.get(i));
        }
    }
}
