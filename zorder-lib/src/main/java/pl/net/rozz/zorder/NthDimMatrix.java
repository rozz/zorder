package pl.net.rozz.zorder;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.collect.Iterables.all;
import static com.google.common.math.IntMath.isPowerOfTwo;
import static java.util.Arrays.asList;

import java.math.RoundingMode;
import java.util.Collection;
import java.util.Collections;

import com.google.common.math.IntMath;

public class NthDimMatrix<T> {

    private int sizeInExpOf2;
    private T[][] data;

    public NthDimMatrix(final T[]... elements) {
        checkArgument(isPowerOfTwo(elements.length), "Matrix size must be a power of 2");

        checkArgument(
                all(asList(elements), (final T[] p) -> isPowerOfTwo(p.length)),
                "Matrix size must be a power of 2");

        sizeInExpOf2 = IntMath.log2(elements.length, RoundingMode.UNNECESSARY);

        data = elements;
    }

    public static <T> NthDimMatrix<T> createMatrix(final T[]... elements) {
        return new NthDimMatrix<T>(elements);
    }

    public int getSizeInTheExpOf2() {
        return sizeInExpOf2;

    }

    public T get(final int coordX, final int coordY) {
        return data[coordX][coordY];
    }

    public Collection<? extends NthDimMatrix<T>> getSubmatrixes() {
        return Collections.emptyList();
    }

}
