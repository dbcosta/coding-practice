package practice.arrays;

import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * 1. Find the minimum and maximum element of an array.
 * 2. Find the Kth smallest/largest number in an array.
 * 3. Reverse an array.
 */
public class ArrayPracticeDay1 {

    private static int findMinMaxElemFromArray(int[] arr,boolean isMax){
        if(arr.length==0){
            return -1;
        }
        if(isMax){
            return IntStream.of(arr).max().getAsInt();
        }else{
            return IntStream.of(arr).min().getAsInt();
        }
    }

    private static int findKthSmallestElement(int[] arr,int k){
        if(arr.length==0){
            return -1;
        }
        return IntStream.of(arr).sorted().skip(1).min().getAsInt();
    }

    private static int findKthLargestElement(int[] arr,int k){
        if(arr.length==0){
            return -1;
        }
        return IntStream.of(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get().intValue();
    }

    public static void main(String[] args) {
        int[] input = new int[]{5,2,1,7,8};
        System.out.println("Input Array:{}"+ input);
        System.out.println("Max element in the array: "+ArrayPracticeDay1.findMinMaxElemFromArray(input,true));
        System.out.println("Min element in the array: "+ArrayPracticeDay1.findMinMaxElemFromArray(input,false));
        System.out.println("If array is empty: "+ArrayPracticeDay1.findMinMaxElemFromArray(new int[]{},false));

        System.out.println("Kth smallest element in the array: "+ArrayPracticeDay1.findKthSmallestElement(input,2));
        System.out.println("Kth largest element in the array: "+ArrayPracticeDay1.findKthLargestElement(input,2));
    }
}
