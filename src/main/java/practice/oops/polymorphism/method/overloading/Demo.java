package practice.oops.polymorphism.method.overloading;

public class Demo {

    public int add(int a,int b){
        return a+b;
    }

    public String add(String a,String b){
        return a+" "+b;
    }

    public double add(float a,float b){
        return a+b;
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        System.out.println(d.add(3,4));
        System.out.println(d.add(3.5f,4.5f));
        System.out.println(d.add("Hello","Belinda"));
    }
}
