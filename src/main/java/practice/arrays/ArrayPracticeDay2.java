package practice.arrays;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 1. Find the occurrence of a given element in an array.
 * 2. Sort a given array.
 * 3. Reverse an array.
 */
public class ArrayPracticeDay2 {

    private static int findOccurrence(int[] arr,int element){
        Map<Integer,Integer> occurrenceMap = new HashMap<>();
        for(Integer i:arr){
            if(occurrenceMap.containsKey(i)){
                occurrenceMap.put(i,occurrenceMap.get(i)+1);
            }else{
                occurrenceMap.put(i,1);
            }
        }
        //printing the occurrence map
        occurrenceMap.entrySet().stream().forEach(entry->{
            System.out.println(entry.getKey()+"="+entry.getValue());
        });
        return occurrenceMap.entrySet().stream().filter(elem->elem.getKey()==element).findFirst().get().getValue();
    }

    /**
     * Will not work for integers greater than 10.
     * @param arr
     * @param n
     * @return
     */
    private static int findOccOldWay(int[] arr,int n){
        int count[] = new int[9];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]= count[arr[i]]+1;
        }
        System.out.println(Arrays.toString(count));
        return count[n];
    }

    private static Map<Integer,Long> findOccurrences(Integer[] arr){
        return Arrays.asList(arr).stream().collect(Collectors.groupingBy(Integer::intValue,Collectors.counting()));
    }

    private static int[] reverseArray(int[] arr){
        int temp = 0,n=arr.length;
        for(int i=0;i<n/2;i++){
            temp=arr[i];
            arr[i]=arr[n-i-1];
            arr[n-i-1]=temp;
        }
        return arr;
    }

    private static int findSmallestPositiveMissingNumber(int[] arr){
        return 0;
    }

    public static void main(String[] args) {
        int[] input = new int[]{5,5,5,2,2,1,1,1,1,7,8,8};
        System.out.println("Occurrence is: "+ArrayPracticeDay2.findOccurrence(input,5));
        System.out.println(ArrayPracticeDay2.findOccOldWay(input,8));
        System.out.println(ArrayPracticeDay2.findOccurrences(new Integer[]{1,4,1,3,1,4,6,7}));

        System.out.println("Reversed Array  is: "+Arrays.toString(ArrayPracticeDay2.reverseArray(input)));
    }
}
