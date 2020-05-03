package algorithm.sort;

import java.util.ArrayList;

/**
 * @author chenjian
 * @date 2020/04/25
 * description:
 **/
public class RadixSort {

    /**
     * 基数排序
     * @param nums
     * @return
     */
    public static int[] sortAscend(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        // 1.先算出最大数的位数；
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < nums.length; j++) {
                int num = (nums[j] % mod) / div;
                bucketList.get(num).add(nums[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++) {
                    nums[index++] = bucketList.get(j).get(k);
                }
                bucketList.get(j).clear();
            }
        }
        return nums;
    }
}
