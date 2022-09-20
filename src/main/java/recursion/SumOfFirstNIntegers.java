package recursion;

/**
 * sum of n numbers => n(n+1)/2
 */
public class SumOfFirstNIntegers {

    private static int findSumOfFirstNIntegers(int n){
        if(n<=1){
            return n;
        }else{
            return n + findSumOfFirstNIntegers(n-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(findSumOfFirstNIntegers(6));
    }
}
