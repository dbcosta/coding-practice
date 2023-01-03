package practice.whats.the.output;

public class Question7 {
    public static void main(String args[]) {
        System.out.println(fun());
    }
    /*int fun() { non-static methods cannot be called from static context
        return 20;
    }*/

    static int fun() {
        return 20;
    }
}
