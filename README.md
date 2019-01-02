# java11-category-theory-reader-functor
_Reference_: https://bartoszmilewski.com/2015/01/20/functors/

# preface
Basic knowledge and intuition about functors is provided in: 
https://github.com/mtumilowicz/java11-category-theory-optional-is-not-functor

**Reader functor**:
```
Type constructor: (-> a) // curried -> a b or equivallent a -> b

map :: (a -> b) -> (r -> a) -> (r -> b)
map f g = (.) f g
```

# proof
1. `map id = id`
    ```
    map id g
    = {definition of map}
    (.) id g
    ```
1. `map (g . f) = map g . map f`
    ```
    map (g . f) h 
    = {definition of map}
    (.) (g . f) h
    = {definition of composing}
    (.) g (f . h)
    = {definition of map}
    map g (f h)
    = {definition of map}
    map g map f h
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
1. Reader could be extended to monad: 
https://github.com/aol/cyclops/blob/master/cyclops-pure/src/main/java/cyclops/control/Reader.java
1. and used for dependency injection: 
https://github.com/aol/cyclops/wiki/Reader-:-functional-dependency-injection