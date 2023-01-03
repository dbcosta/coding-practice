package practice.java8.practice28;

import java.util.*;
import java.util.function.Function;
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
public class Day4 {

    private int findNthMostRepeatedElement(int[] arr,int n){
        return IntStream.of(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((i,j)->j.getValue().compareTo(i.getValue()))
                .skip(n-1)
                .findFirst()
                .get()
                .getKey();
    }

    private int findNthNonRepeatedElement(int[] arr,int n){
        return IntStream.of(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(i->i.getValue()==1L)
                .skip(n-1)
                .findFirst()
                .get()
                .getKey();
    }

    private String findNthMostRepeatedWord(String sentence, int n) {
        String[] words = sentence.split(" ");
        List<String> wordsList = Stream.of(words).collect(Collectors.toList());
        return wordsList
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .skip(n-1)
                .findFirst()
                .get()
                .getKey();

    }

    private void test(String sentence){
        List<String> stringList = Stream.of(sentence).collect(Collectors.toList());
        Map<String, Long> collect =
                stringList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

    }

    public static void main(String[] args) {
        Day4 day4 = new Day4();
        int arr[] = {4,4,4,1,2,3,5,5};
        String sentence = "I love Jesus, Jesus is the best.";
        System.out.println("First most repeated element: "+day4.findNthMostRepeatedElement(arr,1));
        System.out.println("First most non-repeated element: "+day4.findNthNonRepeatedElement(arr,1));
        System.out.println("First most repeated word: "+day4.findNthMostRepeatedWord(sentence,1));
        day4.test(sentence);
    }
}
