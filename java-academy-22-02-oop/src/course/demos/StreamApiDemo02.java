package course.demos;

import course.demos.util.StreamUtil;
import course.demos.util.Tuple2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiDemo02 {
    public static <T> Stream<T> createStream(Collection<T> values) {
        return values == null ? Stream.empty() : values.stream();
    }

    public static void main(String[] args) {
        var empty = Stream.empty();
        empty.forEach(System.out::println);
//        empty.forEach(System.out::println);
        var streamOfVals = Stream.of("hello", "functional", "java", "stream", "api");
//        streamOfVals.forEach(System.out::println);
//        System.out.println();
        var streamOfVals2 = createStream(List.of("hello", "functional", "java", "stream", "api"));
//        streamOfVals2.forEach(System.out::println);
        var streamOfArrayVals =
                Arrays.stream(new String[]{"hello", "functional", "java", "stream", "api"}, 1, 4);
//        streamOfArrayVals.forEach(System.out::println);
        var streamBuilded = Stream.<String>builder().add("hello").add("functional")
                .add("java").add("stream").add("api")
                .build();
//        streamBuilded.forEach(System.out::println);
        var streamGenerated = Stream.generate(() -> Math.random()).limit(100).parallel();
//        streamGenerated.forEach(System.out::println);
        var counter = new AtomicInteger();
        var countedRandoms = Stream.generate(
                        () -> new Tuple2(counter.incrementAndGet(), Math.random()))
                .limit(100).parallel();
//        countedRandoms.forEach(tuple2 -> System.out.printf("%s -> %s%n", tuple2.getV1(),tuple2.getV2()));
        var counterStream = IntStream.iterate(1, i -> i + 1).mapToObj(Integer::valueOf); //mapToObj(Integer::new);
//        counterStream.forEach(System.out::println);
        var countedRandomsZip =
                StreamUtil.zip(counterStream, streamGenerated, (count, random) -> new Tuple2<>(count, random));
        countedRandomsZip.forEach(tuple2 -> System.out.printf("%s -> %s%n", tuple2.getV1(),tuple2.getV2()));

        // String stream
        var charsStream = streamOfVals.flatMapToInt(str -> str.chars());
//        charsStream.forEach(ch -> System.out.print((char)ch + ", "));
    }
}














