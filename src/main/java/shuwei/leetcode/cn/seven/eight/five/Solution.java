package shuwei.leetcode.cn.seven.eight.five;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph.length < 1) {
            return true;
        }
        // 居然有不跟别人连的点
        Set<Integer> nums = new HashSet<>();
        for (int i = 0; i < graph.length; i++){
            nums.add(i);
        }
        int aIndex = 0, aLength = 0;
        int[] aArr = new int[graph.length];
        Set<Integer> aSet = new HashSet<>();
        int bIndex = 0, bLength = 0;
        int[] bArr = new int[graph.length];
        Set<Integer> bSet = new HashSet<>();
        while(aIndex < aLength || bIndex < bLength || nums.size() > 0) {
            if (aIndex == aLength &&bIndex == bLength){
                int num = nums.iterator().next();
                aArr[aLength++] = num;
                aSet.add(num);
            }
            while (aIndex < aLength) {
                int checkNum = aArr[aIndex++];
                nums.remove(checkNum);
                for (int ele : graph[checkNum]) {
                    if (aSet.contains(ele)) {
                        return false;
                    } else {
                        if (bSet.add(ele)){
                            bArr[bLength++] = ele;
                        }
                    }
                }
            }
            while (bIndex < bLength) {
                int checknum = bArr[bIndex++];
                nums.remove(checknum);
                for (int ele : graph[checknum]) {
                    if (bSet.contains(ele)) {
                        return false;
                    } else {
                        if (aSet.add(ele)) {
                            aArr[aLength++] = ele;
                        }
                    }
                }
            }
        }
        return true;
    }
}
