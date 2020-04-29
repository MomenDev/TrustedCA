package test.algorithm.sort;

import algorithm.sort.BubbleSort;
import algorithm.sort.MergeSort;
import algorithm.sort.SelectionSort;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author chenjian
 * @date 2020/04/25
 * description:
 **/
@RunWith(Parameterized.class)
public class SortTestAsend {

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

    private int[] fInput;
    private int[] fExpected;

    public SortTestAsend(int[] fInput, int[] fExpected) {
        this.fInput = fInput;
        this.fExpected = fExpected;
    }

    @Test
    public void sortAscendBubbleSort() {
        Assert.assertArrayEquals(fExpected, BubbleSort.sortAscend(fInput));
    }

    @Test
    public void sortAscendSelectionSort() {
        Assert.assertArrayEquals(fExpected, SelectionSort.sortAscend(fInput));
    }

    @Test
    public void sortAscendMergeSort() {
        Assert.assertArrayEquals(fExpected, MergeSort.sortAscend(fInput));
    }

}