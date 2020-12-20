package shuwei.leetcode.cn.three.one.six;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Solution {

    /**
     * 思路：先计算每个字符的出现索引
     * 从小到大遍历这个序列，尽量找靠前的位置来放自己
     * 找到某个字符以后，按照索引位置从后往前找，如果两个位置之间没有前面的字符站位，那么就可以选更前面这个位置
     * 这个算法不对,cbacdcbc这种测试用例无法通过
     * --------------------------------------------------
     * 不对的问题是后面的更大的字符会屏蔽掉前面的字符，导致前面选择时候的判断逻辑不正确
     * 经过思考，可以改为从后往前安排，在能屏蔽比自己大的字符的情况下，尽量选择更靠后的索引位置
     * 这一样也会有问题，“cbacdcbc”中b为了屏蔽c，选择了前面的，导致a也被屏蔽了
     * --------------------------------------------------
     * 如果每个字符选择最后的位置，adbc,然后在从前往后，看是否能往前调整来减小这个字符串,（这个字符的检查位置的后面的字符是否比这个大）
     * b可以挪到a前面，无法变小，c可以挪到a前面，无法，挪到d前面可以有效果
     * 还是不能通过，在增加一条往前挪的时候
     * ---------------------------------------------------
     * cbacdcbc
     * 如果先取最小的a,然后分为2组由于前面bc跟后面都有重复，所以前面为空，后面为cdcbc
     * 然后找到最小的b，分为2组，发现前面小组和后面小组都有c，前面的去掉c，所以，变成dbc,那么最后的答案是adbc,这个算法也不对
     * ---------------------------------------------------
     * 如果从前往后或者从后往前都不成，能否前后夹击？
     * 最小的字母选择最靠前的是没问题的，最大的字母选择最靠后的是没问题的
     * 从后往前，如果当前字符的最后位置，在它后面的最后位置之前，可以直接放置，如果在它后面元素后面，那么尝试往前放置
     * 从前往后，如果当前字符的最靠前的序列号在，它前面的字符后面，中间没有夹着任何字符，那么可以直接放
     * 貌似还是不对
     * --------------------------------------------------
     * 看了题解以后，思路：
     * 先计算每个字符的位置，然后从头遍历字符串，当stack为空的时候，放入字符
     * 后面遇到的字符如果比这个小，看后面是否有这个字符，如果有，就取出来，再继续比较，如果后面不存在，就将当前字符放入
     * 如果当前字符比stack里面的字符大，就直接放入
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        List<Integer>[] indexs = new ArrayList[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int ind = chars[i] - 'a';
            if (indexs[ind] == null) {
                indexs[ind] = new ArrayList<>();
            }
            indexs[ind].add(i);
        }
        LinkedList<Character> stacks = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if (stacks.isEmpty()) {
                stacks.push(chars[i]);
            } else if (stacks.contains(chars[i])) {
                continue;
            } else {
                char lastChar = stacks.peekLast();
                while (true) {
                    if (lastChar > chars[i]) {
                        int maxIndex = indexs[lastChar - 'a'].get(indexs[lastChar - 'a'].size() - 1);
                        if (maxIndex > i) {
                            stacks.pollLast();
                            if (stacks.size() > 0) {
                                lastChar = stacks.peekLast();
                            } else {
                                stacks.push(chars[i]);
                                break;
                            }
                        } else if (maxIndex < i) {
                            stacks.addLast(chars[i]);
                            break;
                        } else {
                            break;
                        }
                    } else if (lastChar < chars[i]) {
                        stacks.addLast(chars[i]);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (stacks.size() > 0) {
            sb.append(stacks.pollFirst());
        }
        return sb.toString();
    }
}
