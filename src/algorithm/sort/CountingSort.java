package algorithm.sort;

import java.util.Arrays;

/**
 * @author chenjian
 * @date 2020/04/25
 * description:
 **/
public class CountingSort {

    /**
     * 计数排序
     *
     * @param nums
     * @return
     */
    public static int[] sortAscend(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int bias, min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < nums.length) {
            if (bucket[i] != 0) {
                nums[index] = i - bias;
                bucket[i]--;
                index++;
            } else {
                i++;
            }
        }
        return nums;
    }
}
