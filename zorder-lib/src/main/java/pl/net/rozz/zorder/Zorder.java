package pl.net.rozz.zorder;

import java.util.Collection;

public interface Zorder<T> {

    Collection<T> getElementsInLinearOrder(NthDimMatrix<T> matrix);

}
