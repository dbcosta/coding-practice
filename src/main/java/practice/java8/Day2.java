package practice.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1. Find the smallest/shortest & largest/longest element of an integer/string array.
 * 2. Find the nth most repeated element/character in an integer/string array.
 * 3. Find the duplicate elements in an integer/string array.
 * 4. Find the smallest positive/negative number in an array.
 * 5. Find the occurrence of a word/element/char in a string/integer array.
 */
public class Day2 {

    private int findElement(int[] arr,boolean isSmallest){
        return isSmallest?IntStream.of(arr).min().getAsInt():IntStream.of(arr).max().getAsInt();
    }

    private String findElement(String[] arr, boolean isSmallest) {
        return isSmallest ? Stream.of(arr).min(Comparator.comparing(String::length)).get() : Stream.of(arr)
                                                                                                   .max(Comparator.comparing(
                                                                                                           String::length))
                                                                                                   .get();
    }

    private char findNthRepeated(String str, int n) {
        //string to list of characters - Java 9
        List<Character> characters = str.chars().mapToObj(e -> (char) e).collect(Collectors.toList());

        Map<Character, Integer> occurrenceMap = new HashMap<>();
        for(char c:characters){
            occurrenceMap.put(c,Collections.frequency(characters,c));
        }
        System.out.println(occurrenceMap);
        return occurrenceMap.entrySet()
                            .stream()
                            .sorted((i, j) -> j.getValue().compareTo(i.getValue()))
                            .skip(n-1)
                            .findFirst()
                            .get()
                            .getKey();
    }

    private Set<Character> findDuplicates(String str){
        List<Character> characters = str.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        return characters.stream().filter(i->Collections.frequency(characters,i)>1).collect(Collectors.toSet());
    }

    private int findSmallestPositive(int[] arr){
        return Arrays.stream(arr).filter(i->i>0).min().getAsInt();
    }

    private int findOccurrence(String str,char c){
        return Collections.frequency(str.chars().mapToObj(e->(char)e).collect(Collectors.toList()),c);
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,-1,-2,9,0,5,5,6};
        String[] str = {"java","python","javascript","java"};
        Day2 day2 = new Day2();
        System.out.println(day2.findElement(arr,true));
        System.out.println(day2.findElement(arr,false));
        System.out.println(day2.findElement(str,true));
        System.out.println(day2.findElement(str,false));
        System.out.println(day2.findNthRepeated("abbddddccc",3));
        System.out.println(day2.findDuplicates("abbddddccc"));
        System.out.println(day2.findOccurrence("abbddddccc",'b'));
    }
}
