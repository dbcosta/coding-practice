package practice.strings;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1. Given a sentence, reverse it word by word
 * 2. Find the 1st non-repeated char in a string
 * 3. Find the 1st non-repeated char in a string.
 */
public class StringPracticeDay1 {

    private static String reverseString(String sentence){
        List<String> wordsList = Arrays.asList(sentence.split(" "));
        Collections.reverse(wordsList);
        return Arrays.stream(wordsList.stream().toArray(String[]::new)).collect(Collectors.joining(" "));
    }

    private static char findFirstNonRepeatingChar(String input){
        Map<Character, Integer> map = populateMap(input);
        return map.entrySet().stream().filter(v->v.getValue()==1).findFirst().get().getKey();
    }

    private static char findNthNonRepeatingChar(String input,int n){
        Map<Character, Integer> map = populateMap(input);
        return map.entrySet().stream().filter(v->v.getValue()==1).skip(n-1).findFirst().get().getKey();
    }

    private static char findFirstRepeatingChar(String input){
        Map<Character, Integer> map = populateMap(input);
        return map.entrySet().stream().filter(v->v.getValue()>1).findFirst().get().getKey();
    }

    private static char findNthRepeatingChar(String input,int n){
        Map<Character, Integer> map = populateMap(input);
        return map.entrySet().stream().filter(v->v.getValue()>1).skip(n-1).findFirst().get().getKey();
    }

    private static Map<Character, Integer> populateMap(String input) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(Character c: input.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c).intValue()+1);
            }else{
                map.put(c,1);
            }
        }
        return map;
    }


    public static void main(String[] args) {
        System.out.println("Reversed Sentence: "+StringPracticeDay1.reverseString("I work for Globant"));
        System.out.println("First Non repeating char: "+StringPracticeDay1.findFirstNonRepeatingChar("aabdebbff"));
        System.out.println("First Repeating char: "+StringPracticeDay1.findFirstRepeatingChar("aabdebbff"));
        System.out.println("Nth Non repeating char: "+StringPracticeDay1.findNthNonRepeatingChar("aabdebbff",2));
        System.out.println("Nth Repeating char: "+StringPracticeDay1.findNthRepeatingChar("aabdebbff",2));
    }
}
