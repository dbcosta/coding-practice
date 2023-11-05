package practice.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1. Find the smallest/shortest & largest/longest element of an integer/string array.
 * 2. Find the most repeated element in an integer/string array.
 * 3. Find the nth most repeated element/character in an integer/string array.
 * 4. Find the duplicate elements in an integer/string array.
 * 5. Find the smallest positive/negative number in an array.
 * 6. Find the occurrence of a word/element/char in a string/integer array.
 */
public class Day1 {

    private int findElement(int[] arr, boolean isSmallest) {
        return isSmallest ? Arrays.stream(arr).min().orElseThrow() : Arrays.stream(arr).max().orElseThrow();
    }

    private String findElement(String[] arr, boolean isSmallest) {
        return isSmallest ? Arrays.stream(arr).min(Comparator.comparing(String::length)).orElseThrow() :
                Arrays.stream(arr).max(Comparator.comparing(String::length)).orElseThrow();
    }

    private int findNthRepeatedElement(int[] arr,int n){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:arr){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        return map.entrySet().stream().sorted((i,j)->j.getValue().compareTo(i.getValue())).skip(n-1).findFirst().orElseThrow().getKey();
    }

    private int findNthRepeatedElement1(int[] arr,int n){
        Map<Integer,Integer> occurrenceMap = new HashMap<>();
        for(int i: Arrays.stream(arr).distinct().toArray()){
            occurrenceMap.put(i,Collections.frequency(IntStream.of(arr).boxed().toList(),i));
        }
        return occurrenceMap.entrySet()
                            .stream()
                            .sorted((i, j) -> j.getValue().compareTo(i.getValue()))
                            .skip(n - 1)
                            .findFirst()
                            .orElseThrow()
                            .getKey();
    }

    private Set<Integer> findDuplicates(List<Integer> arr){
        return arr.stream().filter(e->Collections.frequency(arr,e)>1).collect(Collectors.toSet());
    }

    private Set<Integer> findDuplicates(int[] arr){
        return IntStream.of(arr).boxed().filter(e->Collections.frequency(IntStream.of(arr).boxed().toList(),e)>1).collect(Collectors.toSet());
    }

    private Set<String> findDuplicates(String[] arr){
        return Stream.of(arr).filter(e->Collections.frequency(List.of(arr),e)>1).collect(Collectors.toSet());
    }

    private int findSmallestPositiveNumber(int[] arr){
        return IntStream.of(arr).filter(i->i>0).min().orElseThrow();
    }

    private int findSmallestNegativeNumber(int[] arr){
        return IntStream.of(arr).filter(i->i<0).min().orElseThrow();
    }

    private int findOccurrence(int[] arr,int n){
        return Collections.frequency(IntStream.of(arr).boxed().toList(),n);
    }

    private int findOccurrence(String[] arr,int n){
        return Collections.frequency(Stream.of(arr).toList(),n);
    }

    public static void main(String[] args) {
        int[] arr = {5,4,2,2,1,1,1,6,6,6,6,-1,-3};
        String[] str = {"java","python","javascript","java"};
        Day1 day1 = new Day1();
        System.out.println(day1.findElement(arr,true));
        System.out.println(day1.findElement(str,true));
        System.out.println(day1.findNthRepeatedElement(arr,3));
        System.out.println(day1.findNthRepeatedElement1(arr,1));
        System.out.println(day1.findDuplicates(str));
        System.out.println(day1.findDuplicates(IntStream.of(arr).boxed().toList()));
        System.out.println(day1.findDuplicates(arr));
        System.out.println(day1.findSmallestPositiveNumber(arr));
        System.out.println(day1.findSmallestNegativeNumber(arr));
        System.out.println(day1.findOccurrence(arr,1));
    }
}
