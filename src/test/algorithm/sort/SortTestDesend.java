package test.algorithm.sort;

import algorithm.sort.BubbleSort;
import algorithm.sort.SelectionSort;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author chenjian
 * @date 2020/04/25
 * description:
 **/
@RunWith(Parameterized.class)
public class SortTestDesend {

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] arr = new Object[][]{
                {new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0}, new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}},
                {new int[]{-8, -9, -1, -7, -2, -3, -5, -4, -6, 0}, new int[]{0, -1, -2, -3, -4, -5, -6, -7, -8, -9}},
                {new int[]{8, 9, 1, 7, 2, -3, 5, 4, 6, 0}, new int[]{9, 8, 7, 6, 5, 4, 2, 1, 0, -3}},
                {new int[]{1}, new int[]{1}},
                {new int[]{}, new int[]{}},
                {null, null},
        };
        return Arrays.asList(arr);
    }

    private int[] input;
    private int[] expected;

    public SortTestDesend(int[] input, int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void sortDescend() {
        Assert.assertArrayEquals(expected, BubbleSort.sortDescend(input));
        Assert.assertArrayEquals(expected, SelectionSort.sortDescend(input));
    }

}