package ds.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayReversal {

    private static void reverseArray(int[] arr){
        for(int i=arr.length-1;i>-1;i--){
            System.out.print(arr[i]);
        }
    }

    private static void reverseArrayJava8(int[] arr){
        List<Integer> integerList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.reverse(integerList);
        System.out.println(integerList);
    }

    private static void reverseArrayJava8(String[] arr){
        List<String> stringList = Arrays.asList(arr);
        Collections.reverse(stringList);
        System.out.println(stringList);
    }

    public static void main(String[] args) {
        int arr[] = {4,5,6,7};
        //reverseArray(arr);
        reverseArrayJava8(arr);
        //System.out.println(Arrays.toString(arr));
    }
}
