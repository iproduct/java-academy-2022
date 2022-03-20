package course.demos;

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
                .mapToInt(word -> {
                    System.out.println(("In second map: " + word));
                    return word.length();
                })
                .limit(2)
                .boxed()
//        .average();
//                .toArray();
                .collect(Collectors.toList());
//                .collect(Collectors.joining(" | "));
        System.out.println(result);
    }
}
