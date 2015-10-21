package pl.net.rozz.zorder;

import static org.junit.Assert.assertArrayEquals;

import java.util.Collection;

import org.junit.Test;

import com.google.common.collect.Iterables;

public class ZorderTest {

    @Test
    public void shouldOrderTwoDimensionalMatrix() {
        //given
        final NthDimMatrix<Integer> simpleMatrix = NthDimMatrix.createMatrix(
                new Integer[] {1,2},
                new Integer[] {3,4}
                );

        final Zorder<Integer> zorder =
                ZorderFactory.getInstance().getNDimensionalFunction(2, Integer.class);

        //when
        final Collection<Integer> orderedIntegers = zorder.getElementsInLinearOrder(simpleMatrix);

        //then
        assertArrayEquals(
                new Integer[] {1,2,3,4},
                Iterables.toArray(orderedIntegers, Integer.class)) ;
    }

}
