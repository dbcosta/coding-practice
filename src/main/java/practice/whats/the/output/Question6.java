package practice.whats.the.output;

public class Question6 {
    public static void main(String[] args) {
        for (int i = 0; true /*1*/; i++) {   //1=compile time error; true=correct
            System.out.println("Hello");
            break;
        }
    }
}
