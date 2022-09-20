package recursion;

import java.util.stream.IntStream;

public class FibonacciSeries {

    private static int findFibonacciSeries(int num){
       if(num==0){
           return 0;
       }else if(num==1){
           return 1;
       }else{
           return findFibonacciSeries(num-1) + findFibonacciSeries(num-2);
       }
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(0,4).forEach(elem->{
            System.out.println(findFibonacciSeries(elem));
        });
    }
}
