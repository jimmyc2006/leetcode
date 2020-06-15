package shuwei.leetcode.cn.one.five;

import java.util.*;

public class Solution {
    // 能ac，但是效率很低
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Deque<Integer>> vAndI = new HashMap<>();
        Set<Data> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            Deque<Integer> dp = vAndI.computeIfAbsent(nums[i], k -> new ArrayDeque<>());
            dp.addFirst(i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                Deque<Integer> indexs = vAndI.get(-sum);
                if (indexs != null) {
                    for (int index : indexs) {
                        if (index != i && index != j) {
                            res.add(new Data(new int[]{nums[i], nums[j], nums[index]}));
                            break;
                        }
                    }
                }
            }
        }
        for (Data d : res) {
            ans.add(Arrays.asList(d.arr[0], d.arr[1], d.arr[2]));
        }
        return ans;
    }

    class Data {
        int[] arr;

        public Data(int[] arr) {
            Arrays.sort(arr);
            this.arr = arr;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Data data = (Data) o;
            return Arrays.equals(arr, data.arr);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(arr);
        }
    }
}
