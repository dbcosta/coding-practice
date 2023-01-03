package practice.oops.polymorphism.method.overriding;

public class Child extends Parent{
    public void foo(){
        System.out.println("This is the child class!");
    }

    public void test(){
        System.out.println("This is the child test class!");
    }

    public static void main(String[] args) {
        Parent parent = new Child();
        parent.foo();
        //parent.test(); //error because test() is not present in the Parent class.
        Child child = new Child();
        child.foo();
    }
}
