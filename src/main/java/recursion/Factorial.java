package recursion;

/**
 * 4! = 4* 3! => 4 * 3 * 2! => 4 * 3 * 2 * 1! => 4 * 3 * 2 * 1 = 24
 */
public class Factorial {

    private static int findFactorial(int num){
        if(num<=0){
            return 0;
        }else if(num == 1){
            return 1;
        } else{
            return num * findFactorial(num-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(findFactorial(3));
    }
}
