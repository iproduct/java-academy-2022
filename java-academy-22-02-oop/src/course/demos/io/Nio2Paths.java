package course.demos.io;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Nio2Paths {
    public static void main(String[] args) {
        Path p1 = Paths.get(".");
        var p2 = p1.toAbsolutePath().normalize();
        System.out.printf("p2: %s -> absolute: %s%n", p2, p2.isAbsolute());
        Path p3 = Paths.get("./src/course/demos/io/Nio2Paths.java").toAbsolutePath().normalize();
        System.out.printf("p3: %s -> absolute: %s%n", p3, p3.isAbsolute());
        var p4 = p2.relativize(p3);
        System.out.printf("p4: %s -> absolute: %s%n", p4, p4.isAbsolute());
        var filter = FileSystems.getDefault().getPathMatcher("glob:*.{java}");
        try {
            // how many line of java code we have written so far?
            var numLines = Files.walk(p1)
                    .filter(path -> Files.isRegularFile(path) && filter.matches(path.getFileName()))
                    .mapToLong(path -> {
                        try {
                            return Files.lines(path).count();
                        } catch (IOException e) {
                            e.printStackTrace();
                            return 0;
                        }
                    }).sum();
            System.out.printf("Lines of conde in project: %d%n", numLines);

            // which are the most used java keywords
            var top20Kwywords = Files.walk(p1)
                    .filter(path -> Files.isRegularFile(path) && filter.matches(path.getFileName()))
                    .map(path -> {
                        try {
                            return Files.lines(path)
                                    .flatMap(line -> Arrays.<String>stream(line.split("\\W+")))
                                    .filter(word -> word.length() >= 2)
                                    .collect(Collectors.groupingBy(
                                            Function.identity(),
                                            Collectors.counting())
                                    );
                        } catch (IOException e) {
                            e.printStackTrace();
                            return Map.<String, Long>of();
                        }
                    }).flatMap(wordCounts -> wordCounts.entrySet().stream())
                    .collect(Collectors.groupingBy(
                            entry -> entry.getKey(),
                            Collectors.summingLong(entry -> entry.getValue()))
                    ).entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .limit(20)
                    .collect(Collectors.toList());
            System.out.println(top20Kwywords);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
