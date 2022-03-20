package course.demos.util;

import java.util.StringJoiner;

public class Tuple3<T1, T2, T3> {
    private T1 v1;
    private T2 v2;
    private T3 v3;

    public Tuple3(T1 v1, T2 v2, T3 v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public T1 getV1() {
        return v1;
    }

    public T2 getV2() {
        return v2;
    }

    public T3 getV3() {
        return v3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple3)) return false;

        Tuple3<?, ?, ?> tuple3 = (Tuple3<?, ?, ?>) o;

        if (getV1() != null ? !getV1().equals(tuple3.getV1()) : tuple3.getV1() != null) return false;
        if (getV2() != null ? !getV2().equals(tuple3.getV2()) : tuple3.getV2() != null) return false;
        return getV3() != null ? getV3().equals(tuple3.getV3()) : tuple3.getV3() == null;
    }

    @Override
    public int hashCode() {
        int result = getV1() != null ? getV1().hashCode() : 0;
        result = 31 * result + (getV2() != null ? getV2().hashCode() : 0);
        result = 31 * result + (getV3() != null ? getV3().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Tuple3.class.getSimpleName() + "[", "]")
                .add("v1=" + v1)
                .add("v2=" + v2)
                .add("v3=" + v3)
                .toString();
    }
}
