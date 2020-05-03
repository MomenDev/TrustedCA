package algorithm.sort;

/**
 * @author chenjian
 * @date 2020/04/25
 * description:
 **/
public class QuickSort {

    public static int[] sortAscend(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        return sortAscend(nums, 0, nums.length - 1);
    }


    /**
     * 快速排序方法
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    static int[] sortAscend(int[] nums, int start, int end) {
        if (start < 0 || end >= nums.length || start > end) {
            return null;
        }
        int smallIndex = partition(nums, start, end);
        if (smallIndex > start) {
            sortAscend(nums, start, smallIndex - 1);
        }
        if (smallIndex < end) {
            sortAscend(nums, smallIndex + 1, end);
        }
        return nums;
    }

    /**
     * 快速排序算法——partition
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex) {
                    swap(array, i, smallIndex);
                }
            }
        }
        return smallIndex;
    }

    /**
     * 交换数组内两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
