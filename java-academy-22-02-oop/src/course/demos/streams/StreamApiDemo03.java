package course.demos.streams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class StreamApiDemo03 {
    public static final List<String> STOP_WORDS = List.of(
            "when", "didn't", "wasn", "y", "few", "below", "into", "there", "his", "these", "about", "if", "again",
            "too", "were", "then", "doing", "haven", "such", "this", "me", "the", "further", "whom", "having",
            "mightn", "both", "him", "she", "don", "yourselves", "all", "do", "it's", "i", "what", "needn", "had",
            "during", "weren", "wasn't", "up", "will", "just", "isn", "theirs", "own", "ll", "hadn", "aren't",
            "while", "hasn't", "themselves", "re", "in", "she's", "wouldn't", "he", "couldn't", "their", "more",
            "that'll", "ain", "t", "a", "was", "but", "couldn", "only", "been", "so", "until", "have", "from",
            "those", "or", "our", "ourselves", "as", "doesn", "over", "how", "you'd", "where", "itself", "against",
            "very", "you'll", "who", "needn't", "by", "no", "each", "its", "at", "we", "any", "ours", "mightn't",
            "through", "does", "here", "didn", "between", "some", "which", "other", "did", "don't", "hasn", "won",
            "not", "should", "haven't", "on", "now", "with", "you", "them", "himself", "under", "you've", "yours",
            "they", "shouldn", "doesn't", "of", "can", "be", "above", "weren't", "wouldn", "for", "s", "and",
            "hadn't", "herself", "nor", "should've", "am", "once", "ve", "an", "hers", "myself", "to", "her", "is",
            "shan't", "are", "same", "being", "your", "than", "it", "aren", "shan", "d", "m", "isn't", "down",
            "shouldn't", "you're", "why", "o", "yourself", "has", "my", "ma", "out", "that", "mustn't", "because",
            "after", "before", "most", "off", "mustn", "won't");

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("data/fp_wiki.txt");
        var lines = Files.lines(path, Charset.forName("utf-8"));
        var words = lines.flatMap(line -> Arrays.stream(line.split("\\W+")))
                .map(String::toLowerCase)
                .filter(word -> word.length() > 2)
                .filter(not(STOP_WORDS::contains));
        var wordCounts = words.collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet();
        var sortedWordCounts = wordCounts.stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry.<String, Long>comparingByKey()));
        var top20WordsCounts = sortedWordCounts.limit(20);
        top20WordsCounts.forEach(System.out::println);
    }
}














