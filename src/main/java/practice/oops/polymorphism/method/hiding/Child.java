package practice.oops.polymorphism.method.hiding;

public class Child extends Parent {
    public static void foo(){
        System.out.println("This is the Child static method!");
    }

    public static void main(String[] args) {
        Parent parent = new Child();
        parent.foo();
        Child child = new Child();
        child.foo();
    }
}
