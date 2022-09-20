package java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestJava8 {

    private static void printAverageOfSquares() {
        IntStream.of(new int[]{2, 3, 4, 5}).map(i -> i * i).average().ifPresent(System.out::println);
        Arrays.stream(new int[]{2, 3, 4, 5}).map(i -> i * i).average().ifPresent(System.out::println);
    }

    /**
     * WAM to print rows from a text file, sort, filter and print.
     */
    private static void printRowsFromFile() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("/Users/belinda/Documents/Coding/src/main/java/java8/bands.txt"));
        lines.sorted().filter(line -> line.length() > 15).forEach(System.out::println);
        lines.close();
    }

    private static void filterRowsFromTextFile() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("/Users/belinda/Documents/Coding/src/main/java/java8/bands.txt"));
        lines.filter(line -> line.contains(" and ")).collect(Collectors.toList()).forEach(System.out::println);
    }

    /**
     * Count the number of clean rows.
     *
     * @throws IOException
     */
    private static void filterCleanRowsFromFile() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("/Users/belinda/Documents/Coding/src/main/java/java8/data.txt"));
        //System.out.println("Number of clean rows: "+lines.map(x->x.split(",")).filter(x->x.length==3).count());

        //stream file and filter out the records with age>30. Parse the data.
        /*lines.map(x -> x.split(","))
             .filter(x -> x.length == 3)
             .filter(x -> Integer.parseInt(x[1]) > 30)
             .forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));*/

        //stream rows from the File, store fields in a Hashmap
        Map<String, Integer> collect = lines.map(x -> x.split(",")).filter(x -> x.length == 3).collect(Collectors.toMap(
                x -> x[0], x -> Integer.parseInt(x[1])
        ));
        collect.entrySet().forEach(x->System.out.println(x.getKey()+" "+x.getValue()));
    }

    private static void summaryStatistics(){
        System.out.println(IntStream.of(7,12,4,8,2).summaryStatistics());
    }

    public static void main(String[] args) throws IOException {
        //TestJava8.printAverageOfSquares();
        //TestJava8.printRowsFromFile();
        List<String> names = Arrays.asList(new String[]{"Java", "Javascript", "Python", "C"})
                                   .stream()
                                   .filter(s -> s.startsWith("J"))
                                   .map(String::toUpperCase)
                                   .collect(Collectors.toList());
        TestJava8.filterRowsFromTextFile();
        TestJava8.filterCleanRowsFromFile();
        TestJava8.summaryStatistics();
    }
}
