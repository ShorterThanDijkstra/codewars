import java.util.function.Function;

public class Main {

}


interface Functor<T> {
    <a, b> T<b> fmap(Function<a, b> f, T<a> in);
}