package java8Feature;

//@FunctionalInterface
public abstract class Converter<F, T> {
    public abstract T convert(F from);
}
