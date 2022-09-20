package iterative;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * When converting from decimal -> binary, always divide by 2.
 */
public class DecimalToBinary {

    private static void printBinary(int decimal){
        List<Integer> list = new ArrayList<>();
        int quotient = decimal;
        do{
            int rem = quotient%2;
            quotient= quotient/2;
            list.add(rem);
        }while(quotient>0);
        Collections.reverse(list);
        list.stream().forEach(System.out::print);
    }

    public static void main(String[] args) {
        printBinary(2);
    }
}
