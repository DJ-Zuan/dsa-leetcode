package com.dj.zuan.dsaleetcode.leetcode.a15;

import java.util.*;

// 本题优化过程时边界情况考虑、退出条件等均考虑错误，且错误多次，需要重做
// 没想出最优解

public class A15ThreeSum {
    public static void main(String[] args) {
        int[] nums = {1, -4, -2, -1, -7, -2, -8, -6, -6, -9, 6, -6, 8, -3, 0, 1};
        List<List<Integer>> res = threeSum(nums);
        return;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result; //不足三个，无结果

        Arrays.sort(nums); //排序

        if (nums[0] + nums[1] > 0 || nums[nums.length - 1] + nums[nums.length - 2] < 0)
            return result; //如果最小的两个之和大于0，或者最大的两个之和小于0，无结果

        Map<Integer, Integer> ele = new HashMap<>();
        for (int i = 0; i < nums.length; i++) //遍历
            ele.put(nums[i], ele.getOrDefault(nums[i], 0) + 1); //对每个值计数

        int l = 0, m, tmp;
        while (l < nums.length - 2 && nums[l] + nums[l + 1] <= 0) { //最左下标 小于 长度-2，且当前最小的两个值之和不大于0
            ele.put(nums[l], ele.get(nums[l]) - 1); //最左下标对应的值剩余数量-1

            m = l + 1; //中下标从 左下标+1 开始
            while (m < nums.length - 1) { //中下标 小于 长度-1
                tmp = 0 - nums[l] - nums[m]; //剩余需要的值
                if (tmp < nums[m]) //如果剩余值小于 中下标 对应的值
                    break; //本轮 最左下标 所对应的所有可能性已遍历完成，退出

                ele.put(nums[m], ele.get(nums[m]) - 1); //中下标对应的值剩余数量-1

                if (ele.getOrDefault(tmp, 0) > 0) { //如果 剩余值 还有
                    List<Integer> s = new ArrayList<>();
                    s.add(nums[l]);
                    s.add(nums[m]);
                    s.add(tmp);
                    result.add(s); //满足条件
                }

                ele.put(nums[m], ele.get(nums[m]) + 1); //中下标对应的值剩余数量+1

                tmp = nums[m];
                while (++m < nums.length - 1 && nums[m] == tmp); //中下标推进到下一个不同的取值
            }

            ele.put(nums[l], ele.get(nums[l]) + 1); //最左下标对应的值的剩余数量+1

            tmp = nums[l];
            while (++l < nums.length - 2 && nums[l] == tmp); //最左下标推进到下一个不同的取值
        }

        return result;
    }
}
