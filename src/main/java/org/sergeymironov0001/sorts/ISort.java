package org.sergeymironov0001.sorts;

public interface ISort {

    <T extends Comparable<T>> void sort(T[] array);
}
