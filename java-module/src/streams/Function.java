package streams;

@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
