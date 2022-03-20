package course.demos;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamApiDemo03 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("data/fp_wiki.txt");
        var lines = Files.lines(path, Charset.forName("utf-8"));
        var words = lines.flatMap(line -> Stream.<String>empty());
        words.forEach(System.out::println);
    }
}














