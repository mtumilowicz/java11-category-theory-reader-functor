# java11-category-theory-reader-functor
_Reference_: https://bartoszmilewski.com/2015/01/20/functors/

# preface
Basic knowledge and intuition about functors is provided in: 
https://github.com/mtumilowicz/java11-optional-is-not-functor

**Reader functor**:
```
Type constructor: -> a (curried -> a b or equivallent a -> b)

fmap :: (a -> b) -> (r -> a) -> (r -> b)
fmap f g = (.) f g
```

# project description
We provide simple implementation of Reader Functor:
```
@FunctionalInterface
interface Reader<R, A> extends Function<R, A> {
    default <B> Function<R, B> map(Function<A, B> f) {
        return f.compose(this);
    }
}

``` 

# additional info
Reader could be extended to monad: 
https://github.com/aol/cyclops/blob/master/cyclops-pure/src/main/java/cyclops/control/Reader.java
and used for dependency injection: 
https://github.com/aol/cyclops/wiki/Reader-:-functional-dependency-injection