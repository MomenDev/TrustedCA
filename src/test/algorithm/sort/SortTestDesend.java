package test.algorithm.sort;

import algorithm.sort.BubbleSort;
import algorithm.sort.MergeSort;
import algorithm.sort.SelectionSort;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author chenjian
 * @date 2020/04/25
 * description:
 **/
@RunWith(Parameterized.class)
public class SortTestDesend {

    @Parameters
    public static Collection<Object[]> data() {
        int[][] src = new int[][]{
                new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0},
                new int[]{-8, -9, -1, -7, -2, -3, -5, -4, -6, 0},
                new int[]{8, 9, 1, 7, 2, -3, 5, 4, 6, 0},
                new int[]{8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0},
        };
        int[][] dst = new int[][]{
                new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0},
                new int[]{-8, -9, -1, -7, -2, -3, -5, -4, -6, 0},
                new int[]{8, 9, 1, 7, 2, -3, 5, 4, 6, 0},
                new int[]{8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0,
                        8, 9, 1, 7, 2, -3, 5, 4, 6, 0, 8, 9, 1, 7, 2, -3, 5, 4, 6, 0},
        };
        for (int i = 0; i < dst.length; i++) {
            Arrays.sort(dst[i]);
            reverseints(dst[i]);
        }

        Object[][] arr = new Object[][]{
                {src[0], dst[0]},
                {src[1], dst[1]},
                {src[2], dst[2]},
                {new int[]{1}, new int[]{1}},
                {new int[]{}, new int[]{}},
                {null, null},
        };
        return Arrays.asList(arr);
    }

    private static void reverseints(int[] nums) {
        int right = nums.length - 1;
        for (int i = 0; i < nums.length / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[right - i];
            nums[right - i] = tmp;
        }
    }

    private int[] input;
    private int[] expected;

    public SortTestDesend(int[] input, int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void sortDescendBubbleSort() {
        Assert.assertArrayEquals(expected, BubbleSort.sortDescend(input));
    }

    @Test
    public void sortDescendSelectionSort() {
        Assert.assertArrayEquals(expected, SelectionSort.sortDescend(input));
    }

    @Test
    public void sortDescend() {
        Assert.assertArrayEquals(expected, MergeSort.sortDescend(input));
    }


}