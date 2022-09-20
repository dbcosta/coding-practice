package ds.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class MinAndMaxElement {

    private static int findMinElement(int arr[]){
        return Arrays.stream(arr).max().getAsInt();
    }

    private static String findMinElement(String[] str){
        return Arrays.stream(str).min(Comparator.comparing(String::length)).get();
    }

    private static int findMaxElement(int arr[]){
        return Arrays.stream(arr).min().getAsInt();
    }

    private static String findMaxElement(String[] str){
        return Stream.of(str).max(Comparator.comparing(String::length)).get();
    }

    public static void main(String[] args) {
        String[] str = {"Java","Javascript","Python"};
        int arr[] = {5,2,4,2,1};
        System.out.println(findMaxElement(arr));
        System.out.println(findMinElement(arr));
        System.out.println(findMinElement(str));
        System.out.println(findMaxElement(str));
    }
}
