package pl.net.rozz.zorder;

import java.util.Collection;
import java.util.function.Function;

public interface Zorder<T> extends Function<NthDimMatrix<T>, Collection<T>> {

    @Override
    Collection<T> apply(NthDimMatrix<T> matrix);

}
