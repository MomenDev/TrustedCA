package algorithm.sort;

/**
 * @author chenjian
 * @date 2020/04/25
 * description:选择排序
 * 每一趟从待排序的数据元素中选出最小（或最大）的一个元素，顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。 选择排序是不稳定的排序方法。
 **/
public class SelectionSort {

    public static int[] sortAscend(int[] nums) {
        if (nums == null) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
        return nums;
    }

    public static int[] sortDescend(int[] nums) {
        if (nums == null) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            int max = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[max] < nums[j]) {
                    max = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[max];
            nums[max] = tmp;
        }
        return nums;
    }
}
