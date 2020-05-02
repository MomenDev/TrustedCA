package algorithm.sort;

/**
 * @author chenjian
 * @date 2020/04/25
 * description:
 **/
public class HeapSort {

    //声明全局变量，用于记录数组array的长度；
    static int len;

    /**
     * 堆排序算法
     *
     * @param nums
     * @return
     */
    public static int[] sortAscend(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        len = nums.length;
        if (len < 1) {
            return nums;
        }
        //1.构建一个最大堆
        buildMaxHeap(nums);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            swap(nums, 0, len - 1);
            len--;
            adjustHeap(nums, 0);
        }
        return nums;
    }

    /**
     * 建立最大堆
     *
     * @param array
     */
    public static void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始向上构造最大堆
        for (int i = (len / 2 - 1); i >= 0; i--) { //感谢 @让我发会呆 网友的提醒，此处应该为 i = (len/2 - 1)
            adjustHeap(array, i);
        }
    }

    /**
     * 调整使之成为最大堆
     *
     * @param array
     * @param i
     */
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 < len && array[i * 2] > array[maxIndex]) {
            maxIndex = i * 2;
        }
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex]) {
            maxIndex = i * 2 + 1;
        }
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }

    public static void swap(int[] arr, int indexa, int indexb) {
        int temp = arr[indexa];
        arr[indexa] = arr[indexb];
        arr[indexb] = temp;
    }
}
