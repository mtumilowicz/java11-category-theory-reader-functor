import java.util.function.Function;

/**
 * Created by mtumilowicz on 2019-01-02.
 */
@FunctionalInterface
interface Reader<R, A> extends Function<R, A> {
    default <B> Reader<R, B> map(Function<A, B> f) {
        return asReader(f.compose(this));
    }
    
    default <X, Y> Reader<X, Y> asReader(Function<X, Y> f) {
        return f::apply;
    }
}
