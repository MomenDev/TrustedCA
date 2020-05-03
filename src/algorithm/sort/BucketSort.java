package algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenjian
 * @date 2020/04/25
 * description:
 **/
public class BucketSort {

    public static int[] sortAscend(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        ArrayList<Integer> arrayList = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            arrayList.add(nums[i]);
        }
        ArrayList<Integer> ret = sort(arrayList, 5);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ret.get(i);
        }
        return nums;
    }

    /**
     * 桶排序
     *
     * @param nums
     * @param bucketSize
     * @return
     */
    public static ArrayList<Integer> sort(ArrayList<Integer> nums, int bucketSize) {
        if (nums == null || nums.size() < 2) {
            return nums;
        }
        int max = nums.get(0), min = nums.get(0);
        // 找到最大值最小值
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) > max) {
                max = nums.get(i);
            }
            if (nums.get(i) < min) {
                min = nums.get(i);
            }
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < nums.size(); i++) {
            bucketArr.get((nums.get(i) - min) / bucketSize).add(nums.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) {
                for (int j = 0; j < bucketArr.get(i).size(); j++) {
                    resultArr.add(bucketArr.get(i).get(j));
                }
            } else {
                if (bucketCount == 1) {
                    bucketSize--;
                }
                ArrayList<Integer> temp = sort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++) {
                    resultArr.add(temp.get(j));
                }
            }
        }
        return resultArr;
    }
}
