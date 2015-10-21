package pl.net.rozz.zorder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NthDimMatrixTest {

    @Test
    public void shouldReturnSize1OnMatrix2x2() {
        final NthDimMatrix<Integer> matrix2x2 = NthDimMatrix.createMatrix(
                new Integer[] {1,2},
                new Integer[] {3,4}
                );
        assertEquals(1, matrix2x2.getSizeInTheExpOf2());
    }


    @Test
    public void shouldReturnSize2OnMatrix4x4() {
        final NthDimMatrix<Integer> matrix4x4 = NthDimMatrix.createMatrix(
                new Integer[] {1,2,3,4},
                new Integer[] {5,6,7,8},
                new Integer[] {5,6,7,8},
                new Integer[] {5,6,7,8}
                );
        assertEquals(2, matrix4x4.getSizeInTheExpOf2());
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldFailWhenMatrixNotAPowerOf2() {
        NthDimMatrix.createMatrix(
                new Integer[] {1,2,3},
                new Integer[] {5,8},
                new Integer[] {5,6,7,8,2}
                );
    }

}
