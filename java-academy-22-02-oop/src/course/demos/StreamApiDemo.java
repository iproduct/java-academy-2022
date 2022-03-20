package course.demos;

import course.demos.util.Tuple2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamApiDemo {
    public static void main(String[] args) {
        String[] data = {"hello", "from", "java", "stream", "api"};
        var result = Arrays.asList(data).stream()
                .map(word -> {
                    System.out.println(("In before skip map: " + word));
                    return word;
                })
                .skip(1)
                .map(word -> {
                    System.out.println(("In map: " + word));
                    return word.toUpperCase();
                })
                .filter(word -> {
                    System.out.println(("In filter: " + word));
                    return word.contains("A");
                })
                .map(word -> {
                    System.out.println(("In second map: " + word));
                    return new Tuple2(word, Integer.valueOf(word.length()));
                })
                .limit(2)
//        .average();
//                .toArray();
                .collect(Collectors.toMap(tuple2 -> tuple2.getV1(), tuple2 -> tuple2.getV2()));
//                .collect(Collectors.joining(" | "));
        System.out.println(result);
    }
}

















