package course.demos.util;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiFunction;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.Spliterator.SIZED;

public class StreamUtil {
    public static <A, B, C> Stream<C> zip(Stream<A> streamA, Stream<B> streamB, BiFunction<A, B, C> zipper) {
        Objects.requireNonNull(zipper);
        Spliterator<? extends A> aSpliterator = Objects.requireNonNull(streamA).spliterator();
        Spliterator<? extends B> bSpliterator = Objects.requireNonNull(streamB).spliterator();

        // Zipping looses DISTINCT and SORTED characteristics
        int characteristics = ((aSpliterator.characteristics() & bSpliterator.characteristics()
                & ~(Spliterator.DISTINCT | Spliterator.SORTED))
                | (aSpliterator.characteristics() & Spliterator.SIZED | bSpliterator.characteristics() & Spliterator.SIZED));

        long zipSize = (aSpliterator.getExactSizeIfKnown() >= 0) ?
                ((bSpliterator.getExactSizeIfKnown() >= 0) ?
                        Math.min(aSpliterator.estimateSize(), bSpliterator.estimateSize())
                        : aSpliterator.estimateSize())
                :bSpliterator.getExactSizeIfKnown();

        final Iterator<A> iteratorA = Spliterators.iterator(aSpliterator);
        final Iterator<B> iteratorB = Spliterators.iterator(bSpliterator);
        final Iterator<C> iteratorC = new Iterator<C>() {
            @Override
            public boolean hasNext() {
                return iteratorA.hasNext() && iteratorB.hasNext();
            }

            @Override
            public C next() {
                return zipper.apply(iteratorA.next(), iteratorB.next());
            }
        };
        Spliterator<C> split = zipSize > 0 ? Spliterators.spliterator(iteratorC, zipSize, characteristics):
                Spliterators.spliteratorUnknownSize(iteratorC, characteristics);
        return StreamSupport.stream(split, streamA.isParallel() || streamA.isParallel());
    }
}
