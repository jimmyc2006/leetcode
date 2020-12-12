package shuwei.leetcode.cn.six.four.nine;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private static final char dd = 'D';
    private static final int cdIndex = 0;
    private static final char rr = 'R';
    private static final int crIndex = 1;

    public String predictPartyVictory(String senate) {
        char[] chars = senate.toCharArray();
        int[] counts = new int[2];
        LinkedList<Integer> aliveDIndexs = new LinkedList<>();
        LinkedList<Integer> aliveRIndexs = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            this.deal(i, chars, counts, aliveDIndexs, aliveRIndexs);
        }
        this.merge(counts, aliveDIndexs, aliveRIndexs);
        while (aliveDIndexs.size() > 0 && aliveRIndexs.size() > 0) {
            counts[cdIndex] = 0;
            counts[crIndex] = 0;
            LinkedList dl = new LinkedList<>();
            LinkedList rl = new LinkedList<>();
            while (aliveDIndexs.size() > 0 || aliveRIndexs.size() > 0) {
                int index;
                if (aliveDIndexs.size() == 0) {
                    index = aliveRIndexs.pollFirst();
                } else if (aliveRIndexs.size() == 0) {
                    index = aliveDIndexs.pollFirst();
                } else {
                    if (aliveDIndexs.peekFirst() > aliveRIndexs.peekFirst()) {
                        index = aliveRIndexs.pollFirst();
                    } else {
                        index = aliveDIndexs.pollFirst();
                    }
                }
                this.deal(index, chars, counts, dl, rl);
            }
            this.merge(counts, dl, rl);
            aliveDIndexs = dl;
            aliveRIndexs = rl;
        }
        if (aliveDIndexs.size() > 0) {
            return "Dire";
        } else {
            return "Radiant";
        }
    }

    private void deal(int index, char[] chars, int[] counts, LinkedList<Integer> aliveDIndexs, LinkedList<Integer> aliveRIndexs) {
        if (chars[index] == dd) {
            if (counts[crIndex] > 0) {
                counts[crIndex]--;
            } else {
                aliveDIndexs.addLast(index);
                counts[cdIndex]++;
            }
        } else {
            if (counts[cdIndex] > 0) {
                counts[cdIndex]--;
            } else {
                aliveRIndexs.addLast(index);
                counts[crIndex]++;
            }
        }
    }

    private void merge(int[] counts, LinkedList<Integer> aliveDIndexs, LinkedList<Integer> aliveRIndexs) {
        while (counts[cdIndex] > 0) {
            if (aliveRIndexs.size() > 0) {
                aliveRIndexs.pollFirst();
                counts[cdIndex]--;
            } else {
                break;
            }
        }
        while (counts[crIndex] > 0) {
            if (aliveDIndexs.size() > 0) {
                aliveDIndexs.removeFirst();
                counts[crIndex]--;
            } else {
                break;
            }
        }
    }
}
