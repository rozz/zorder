package pl.net.rozz.zorder;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Queue;

import com.google.common.collect.Lists;

class Zorder2dImpl<T> implements Zorder<T> {

    @Override
    public Collection<T> apply(final NthDimMatrix<T> matrix) {
        final Queue<NthDimMatrix<T>> matrixQueue = Lists.newLinkedList();
        matrixQueue.add(matrix);

        return processQueueUntilEmpty(matrixQueue, (final NthDimMatrix<T> inputMatrix) -> {
            if (inputMatrix.getSizeInTheExpOf2() == 1)
                return Arrays.asList(
                        inputMatrix.get(0,0),inputMatrix.get(0,1),
                        inputMatrix.get(1,0),inputMatrix.get(1,1));
            else {
                matrixQueue.addAll(inputMatrix.getSubmatrixes());
                return Collections.emptyList();
            }
        });
    }

    private Collection<T> processQueueUntilEmpty(final Queue<NthDimMatrix<T>> matrixQueue, final Zorder<T> zorder) {
        final Collection<T> orderedElements = Lists.newArrayList();
        while(true) {
            final NthDimMatrix<T> currentMatrix = matrixQueue.poll();

            if (currentMatrix == null) {
                break;
            }

            orderedElements.addAll(zorder.apply(currentMatrix));
        }
        return orderedElements;
    }

}
