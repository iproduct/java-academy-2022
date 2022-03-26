package course.demos.streams.util;

import java.util.StringJoiner;

public class Tuple2<T1, T2> {
    private T1 v1;
    private T2 v2;

    public Tuple2(T1 v1, T2 v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public T1 getV1() {
        return v1;
    }

    public T2 getV2() {
        return v2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple2)) return false;

        Tuple2<?, ?> tuple = (Tuple2<?, ?>) o;

        if (getV1() != null ? !getV1().equals(tuple.getV1()) : tuple.getV1() != null) return false;
        return getV2() != null ? getV2().equals(tuple.getV2()) : tuple.getV2() == null;
    }

    @Override
    public int hashCode() {
        int result = getV1() != null ? getV1().hashCode() : 0;
        result = 31 * result + (getV2() != null ? getV2().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Tuple2.class.getSimpleName() + "[", "]")
                .add("v1=" + v1)
                .add("v2=" + v2)
                .toString();
    }
}
