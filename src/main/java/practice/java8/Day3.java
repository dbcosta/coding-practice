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
public class Day3 {

    /**
     * Find smallest/longest element in an integer array.
     * @param arr
     * @param isSmallest
     * @return
     */
    private int findElement(int[] arr, boolean isSmallest) {
        return isSmallest ? IntStream.of(arr).min().getAsInt() : IntStream.of(arr).max().getAsInt();
    }

    /**
     * Find smallest/longest element in a String array.
     * @param arr
     * @param isSmallest
     * @return
     */
    private String findElement(String[] arr, boolean isSmallest){
        return Stream.of(arr).min(Comparator.comparing(String::length)).get();
    }

    /**
     * Find the nth most repeated element in an integer array.
     * @param arr
     * @param n
     * @return
     */
    private int findNthMostRepeated(int[] arr, int n) {
        Map<Integer, Integer> occurrenceMap = new HashMap<>();
        List<Integer> integerList = IntStream.of(arr).boxed().distinct().toList();
        for (int i : integerList) {
            occurrenceMap.put(i, Collections.frequency(integerList, i));
        }
        return occurrenceMap.entrySet()
                            .stream()
                            .sorted((i, j) -> j.getValue().compareTo(i.getValue()))
                            .skip(n - 1)
                            .findFirst()
                            .get()
                            .getKey();
    }

    /**
     * Find the nth most repeated character in a single word.
     * @param str
     * @param n
     * @return
     */
    private char findNthMostRepeatedCharacter(String str, int n) {
        List<Character> characters = str.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        Map<Character, Integer> occurrenceMap = new HashMap<>();
        for (char c : characters) {
            occurrenceMap.put(c, Collections.frequency(characters, c));
        }
        return occurrenceMap.entrySet()
                            .stream()
                            .sorted((i, j) -> j.getValue().compareTo(i.getValue()))
                            .skip(n - 1)
                            .findFirst()
                            .get()
                            .getKey();
    }

    /**
     * Find the nth most repeated word in a sentence.
     * @param str
     * @param n
     * @return
     */
    private String findNthMostRepeatedWord(String str, int n) {
        List<String> words = Arrays.stream(str.split(" ")).toList();
        Map<String, Integer> occurrenceMap = new HashMap<>();
        for (String s : words) {
            occurrenceMap.put(s, Collections.frequency(words, s));
        }
        return occurrenceMap.entrySet()
                            .stream()
                            .sorted((i, j) -> j.getValue().compareTo(i.getValue()))
                            .skip(n - 1)
                            .findFirst()
                            .get()
                            .getKey();
    }

    /**
     * Find duplicate integers in an integer array
     * @param arr
     * @return
     */
    private List<Integer> findDuplicates(int[] arr){
        return IntStream.of(arr).boxed().filter(i->Collections.frequency(IntStream.of(arr).boxed().toList(),i)>1).collect(Collectors.toList());
    }

    /**
     * Find duplicate Strings in a String array
     * @param arr
     * @return
     */
    private List<String> findDuplicates(String[] arr){
        return Stream.of(arr).filter(i->Collections.frequency(Stream.of(arr).toList(),i)>1).collect(Collectors.toList());
    }

    /**
     * Find duplicate characters in a string.
     * @param str
     * @return
     */
    private List<Character> findDuplicates(String str){
        List<Character> characters = str.chars().mapToObj(e->(char)e).toList();
        return characters.stream().filter(i->Collections.frequency(characters,i)>1).collect(Collectors.toList());
    }

    /**
     * Find the smallest positive/negative elements in integer array.
     * @param arr
     * @param isPositive
     * @return
     */
    private int findSmallestElement(int[] arr, boolean isPositive) {
        List<Integer> integers = IntStream.of(arr).boxed().toList();
        return isPositive ? integers.stream().filter(i -> i > 0).min(Integer::compareTo).get().intValue() :
                integers.stream().filter(i -> i < 0).min(Integer::compareTo).get().intValue();
    }

}
