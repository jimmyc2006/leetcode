package shuwei.leetcode.cn.one.one.zero.four;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> ans = new LinkedList<>();
        while (label != 1) {
            ans.addFirst(label);
            int level = findLevel(label);
            int parentPosition = findParentPosition(level, label);
            label = findNumber(level - 1, parentPosition);
        }
        ans.addFirst(1);
        return ans;
    }

    private int findNumber(int level, int sequence) {
        int start = findStart(level);
        if (level % 2 == 0) {
            return start + positionCount(level) - sequence - 1;
        } else {
            return start + sequence;
        }
    }

    private int findParentPosition(int level, int num) {
        int start = findStart(level);
        // 从0开始
        int group = (num - start) / 2;
        if (level % 2 == 0) {
            // 从右往左
            int parentLevelGroups = positionCount(level - 1);
            return parentLevelGroups - group - 1;
        } else {
            return group;
        }
    }

    private int positionCount(int level) {
        // 1 -> 1, 2- > 2
        return findStart(level);
    }

    private int findStart(int level) {
        int num = level - 1;
        int result = 1;
        while (num > 0) {
            result = result << 1;
            num--;
        }
        return result;
    }

    private int findLevel(int num) {
        int result = 0;
        while(num > 0) {
            result++;
            num = num >>> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.findParentPosition(4, 14));
        System.out.println(solution.pathInZigZagTree(14));
        System.out.println(solution.pathInZigZagTree(26));
    }
}
