package shuwei.leetcode.cn.eight.four.five;

public class Solution {

    /**
     * 遍历一遍数组，记录当前状态，如果当前是上山，遇到变小，则变为下山
     * 如果当前为下山，遇到上升，则结算，那么就重新开始一座山
     * @param A
     * @return
     */
    public int longestMountain(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int startIndex = 0;
        while (startIndex + 1 < A.length) {
            if (A[startIndex + 1] > A[startIndex]) {
                break;
            }
            startIndex++;
        }
        boolean isDown = false;
        int currMountain = 1;
        int maxMountain = 0;
        for (int i = startIndex; i + 1 < A.length; i++) {
            if (isDown) {
                if (A[i + 1] < A[i]) {
                    currMountain++;
                } else {
                    // 山脉结束
                    if (currMountain >= 3) {
                        maxMountain = Math.max(currMountain, maxMountain);
                    }
                    if (A[i + 1] == A[i]) {
                        currMountain = 1;
                    } else {
                        currMountain = 2;
                    }
                    isDown = false;
                }
            } else {
                if (A[i + 1] > A[i]) {
                    currMountain++;
                } else if (A[i + 1] < A[i] && currMountain > 1)  {
                    currMountain++;
                    isDown = true;
                } else {
                    currMountain = 1;
                }
            }
        }
        if (isDown && currMountain >= 3) {
            maxMountain = Math.max(currMountain, maxMountain);
        }
        return maxMountain;
    }

}
