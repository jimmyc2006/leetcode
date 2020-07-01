package shuwei.leetcode.cn.two.one.five;

import javafx.collections.transformation.SortedList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Solution {

    // 5ms 64%
    public int findKthLargest2(int[] nums, int k) {
        if (k > nums.length) {
            return 0;
        }
        PriorityQueue<Integer> ts = new PriorityQueue<>(k, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                return (int)o1 - (int)o2;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if (ts.size() < k ) {
                ts.add(nums[i]);
            } else {
                Integer min = ts.peek();
                if (min < nums[i]) {
                    ts.remove(min);
                    ts.add(nums[i]);
                }
            }
        }
        return ts.peek();
    }

    // 2ms 92%
    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length) {
            return 0;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
