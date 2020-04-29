package algorithm.sort;

/**
 * @author chenjian
 * @date 2020/04/25
 * description:归并排序
 **/
public class MergeSort {

    public static int[] sortAscend(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return nums;
        }
        int[] temp = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        sortMerge(nums, start, end, temp);
        return nums;
    }

    private static void sortMerge(int[] nums, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sortMerge(nums, start, mid, temp);
        sortMerge(nums, mid + 1, end, temp);
        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        for (int i = start; i <= end; i++) {
            temp[i] = nums[i];
        }
        int lindex = start;
        int rindex = mid + 1;

        for (int i = start; i <= end; i++) {
            if (lindex == mid + 1) {
                nums[i] = temp[rindex++];
            } else if (rindex == end + 1) {
                nums[i] = temp[lindex++];
            } else if (temp[lindex] > temp[rindex]) {
                nums[i] = temp[rindex++];
            } else {
                nums[i] = temp[lindex++];
            }
        }
    }

    public static int[] sortDescend(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return nums;
        }
        int[] temp = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        sortMergeD(nums, start, end, temp);
        return nums;
    }

    private static void sortMergeD(int[] nums, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sortMergeD(nums, start, mid, temp);
        sortMergeD(nums, mid + 1, end, temp);
        if (nums[mid] >= nums[mid + 1]) {
            return;
        }
        for (int i = start; i <= end; i++) {
            temp[i] = nums[i];
        }
        int lindex = start;
        int rindex = mid + 1;

        for (int i = start; i <= end; i++) {
            if (lindex == mid + 1) {
                nums[i] = temp[rindex++];
            } else if (rindex == end + 1) {
                nums[i] = temp[lindex++];
            } else if (temp[lindex] <= temp[rindex]) {
                nums[i] = temp[rindex++];
            } else {
                nums[i] = temp[lindex++];
            }
        }
    }

}
