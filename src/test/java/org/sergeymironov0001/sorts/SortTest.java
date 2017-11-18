package org.sergeymironov0001.sorts;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

public class SortTest {
    private static final int RANDOM_TESTS_COUNT = 100;
    private static final int MAX_ARRAY_SIZE = 50;

    private ISort sort;

    @Before
    public void init() {
        sort = new BubbleSort();
    }

    @Test(expected = IllegalArgumentException.class)
    public void sortThrowsIllegalArgumentExceptionIfInputArrayIsNull() {
        sort.sort(null);
    }

    @Test
    public void sortWorksCorrectForEmptyArray() {
        sort.sort(new Integer[0]);
    }

    @Test
    public void sortWorksCorrectForSortedArray() {
        Integer[] inputArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        sort.sort(inputArray);

        checkSort(inputArray);
    }

    @Test
    public void sortWorksCorrectForInverseSortedArray() {
        Integer[] inputArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort.sort(inputArray);

        checkSort(inputArray);
    }

    @Test
    public void sortWorksCorrectForRandomArrays() {
        Random random = new Random();

        for (int i = 0; i < RANDOM_TESTS_COUNT; i++) {
            int length = random.nextInt(MAX_ARRAY_SIZE);
            Integer[] inputArray = generateRandomArray(random, length);
            sort.sort(inputArray);
            checkSort(inputArray);
        }
    }

    private static Integer[] generateRandomArray(Random random, int length) {
        return random.ints(length).boxed().toArray(Integer[]::new);
    }

    private static <T extends Comparable<T>> void checkSort(T[] array) {
        try {
            IntStream.range(1, array.length)
                    .forEach(i -> assertThat(array[i], greaterThanOrEqualTo(array[i - 1])));
        } catch (Throwable exception) {
            System.out.println(String.format("Array not sorted:\n%s", Arrays.toString(array)));
            throw exception;
        }
    }
}