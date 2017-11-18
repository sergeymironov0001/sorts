package org.sergeymironov0001.sorts;

import java.util.Objects;

public abstract class AbstractSort implements ISort {

    protected <T> void validateArray(T[] array) {
        if (Objects.isNull(array)) {
            throw new IllegalArgumentException("Array to sort can't be null");
        }
    }

    protected <T extends Comparable<T>> int compare(T[] array, int index1, int index2) {
        return array[index1].compareTo(array[index2]);
    }

    protected <T> void swap(T[] array, int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
