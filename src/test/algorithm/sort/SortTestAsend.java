package test.algorithm.sort;

import algorithm.sort.BubbleSort;
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
        Object[][] arr = new Object[][]{
                {new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0}, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}},
                {new int[]{-8, -9, -1, -7, -2, -3, -5, -4, -6, 0}, new int[]{-9, -8, -7, -6, -5, -4, -3, -2, -1, 0}},
                {new int[]{8, 9, 1, 7, 2, -3, 5, 4, 6, 0}, new int[]{-3, 0, 1, 2, 4, 5, 6, 7, 8, 9}},
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
    public void sortAscend() {
        Assert.assertArrayEquals(fExpected, BubbleSort.sortAscend(fInput));
        Assert.assertArrayEquals(fExpected, SelectionSort.sortAscend(fInput));
    }

    @Test
    public void sortDescend() {
        int[] src = null;
        src = new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        Assert.assertArrayEquals(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, BubbleSort.sortDescend(src));

        src = new int[]{-8, -9, -1, -7, -2, -3, -5, -4, -6, 0};
        Assert.assertArrayEquals(new int[]{0, -1, -2, -3, -4, -5, -6, -7, -8, -9}, BubbleSort.sortDescend(src));

        src = new int[]{};
        Assert.assertArrayEquals(new int[]{}, BubbleSort.sortDescend(src));

        src = new int[]{1};
        Assert.assertArrayEquals(new int[]{1}, BubbleSort.sortDescend(src));
    }

}