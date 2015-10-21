package pl.net.rozz.zorder;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.collect.Iterables.all;
import static com.google.common.math.IntMath.isPowerOfTwo;
import static java.util.Arrays.asList;

import java.math.RoundingMode;

import com.google.common.base.Predicate;
import com.google.common.math.IntMath;

public class NthDimMatrix<T> {

    private static int sizeInExpOf2;

    public static <T> NthDimMatrix<T> createMatrix(final T[]... elements) {
        checkArgument(isPowerOfTwo(elements.length), "Matrix size must be a power of 2");

        checkArgument(all(asList(elements), new Predicate<T[]>() {

            @Override
            public boolean apply(final T[] input) {
                return isPowerOfTwo(input.length);
            }
        }),"Matrix size must be a power of 2");

        sizeInExpOf2 = IntMath.log2(elements.length, RoundingMode.UNNECESSARY);

        return new NthDimMatrix<T>();
    }

    public int getSizeInTheExpOf2() {
        return sizeInExpOf2;

    }

}
