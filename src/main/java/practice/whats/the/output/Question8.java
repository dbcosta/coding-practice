package practice.whats.the.output;

public class Question8 {
    static int x = 0;
    public static void main(String[] args) {
        System.out.println(fun());
    }
    static int fun() {
        //static int x= 0; static local variables are not allowed in java
        return ++x;
    }
}
