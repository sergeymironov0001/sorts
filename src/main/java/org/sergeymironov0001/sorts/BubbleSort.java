package org.sergeymironov0001.sorts;

public class BubbleSort extends AbstractSort {

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        validateArray(array);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (compare(array, j, j + 1) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
}
