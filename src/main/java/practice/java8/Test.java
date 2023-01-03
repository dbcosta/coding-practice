package practice.java8;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    private static List<Integer> findEvenNumbers(List<Integer> integerList) {
        return integerList.stream().filter(i -> i % 2 == 0).distinct().collect(Collectors.toList());
    }

    private static List<Integer> findNosStartingWithOne(List<Integer> integerList) {
        return integerList.stream()
                          .map(s -> s + "")//convert integer to string
                          .filter(s -> s.startsWith("1"))
                          .map(s -> Integer.valueOf(s))
                          .distinct()//convert string to integer
                          .collect(Collectors.toList());
    }

    private static List<Integer> findDuplicates(List<Integer> integerList) {
        Set<Integer> integerSet = new HashSet<>();
        return integerList.stream().filter(s -> !integerSet.add(s)).collect(Collectors.toList());
    }

    private static int findElement(List<Integer> integerList){
        return integerList.stream().max(Integer::compareTo).get();
        //return integerList.stream().count();
        //return integerList.stream().findFirst().get().intValue();
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(13, 24, 22, 31, 10, 10);
        System.out.println(findEvenNumbers(integerList));
        System.out.println(findNosStartingWithOne(integerList));
        System.out.println(findDuplicates(integerList));
        System.out.println(findElement(integerList));
    }
}
