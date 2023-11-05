package practice.strings;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Check if 2 strings are anagrams of each other.
 */
public class Anagram {
    private static boolean isAnagram(String first,String second){
        if(StringUtils.isAllBlank(first,second) || first.length()!=second.length()){
            return false;
        }
        List<Character> secondCharsList = second.chars().mapToObj(e->(char)e).collect(Collectors.toList());

        for(char c:first.toCharArray()){
            if(!secondCharsList.contains(c)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Map<String,String> dictionary = new HashMap<>();
        dictionary.put("care","race");
        dictionary.put("car","tar");
        dictionary.put("eat","tea");
        dictionary.put("seat","test");
        Map<Boolean, List<Map.Entry<String, String>>> booleanListMap = dictionary.entrySet()
                                                                          .stream()
                                                                          .collect(Collectors.partitioningBy(
                                                                                  e -> Anagram.isAnagram(e.getKey(),
                                                                                          e.getValue())));
        System.out.println(booleanListMap);

    }
}
