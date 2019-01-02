import java.util.function.Function;

/**
 * Created by mtumilowicz on 2019-01-02.
 */
@FunctionalInterface
interface Reader<R, A> extends Function<R, A> {
    default <B> Function<R, B> map(Function<A, B> f) {
        return f.compose(this);
    }
}
