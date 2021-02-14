package shuwei.leetcode.cn.seven.zero.three;


public class RollPriorityQueue {

    int currIndex = 1;
    int size;
    int[] data;

    public RollPriorityQueue(int size) {
        this.size = size + 1;
        this.data = new int[this.size];
    }

    /**
     * 1
     * 2     3
     * 4 5   6 7
     *
     * @param val
     * @return
     */
    public int add(int val) {
        if (currIndex == size) {
            if (val > data[1]) {
                exch(val);
            }
        } else {
            data[currIndex] = val;
            up(currIndex);
            currIndex++;
        }
        return data[1];
    }

    private void exch(int val) {
        data[1] = val;
        down(1);
    }

    private void down(int index) {
        int c1;
        while ((c1 = index * 2) < currIndex) {
            int c2 = c1 + 1;
            if (c2 < currIndex && data[c2] < data[c1]) {
                c1 = c2;
            }
            if (data[index] <= data[c1]) {
                break;
            }
            swap(index, c1);
            index = c1;
        }
    }

    private void up(int index) {
        while (index >= 2) {
            int p = index / 2;
            if (data[p] <= data[index]) {
                break;
            }
            swap(p, index);
            index = p;
        }
    }

    private void swap(int i1, int i2) {
        int tmp = data[i1];
        data[i1] = data[i2];
        data[i2] = tmp;
    }
}
