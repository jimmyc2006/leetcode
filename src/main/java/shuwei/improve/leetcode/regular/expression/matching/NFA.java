package shuwei.improve.leetcode.regular.expression.matching;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NFA {
    private char[] re;
    private Digraph digraph;
    private int length;
    
    public NFA(String regex) {
        Stack<Integer> ops = new Stack<Integer>();
        re = regex.toCharArray();
        this.length = re.length;
        digraph = new Digraph(length + 1);
        for(int i = 0; i < length; i++) {
            int lp = i;
            if(re[i] == '(' || re[i] == '|') {
                ops.push(i);
            } else if(re[i] == ')') {
                int or = ops.pop();
                if(re[or] == '|') {
                    lp = ops.pop();
                    digraph.addEdge(lp, or + 1);
                    digraph.addEdge(or, i);
                } else {
                    lp = or;
                }
            }
            if(i < length - 1 && re[i + 1] == '*') {
                digraph.addEdge(lp, i + 1);
                digraph.addEdge(i + 1, lp);
            }
            if(re[i] == '(' || re[i] == '*' || re[i] == ')') {
                digraph.addEdge(i, i + 1);
            }
        }
    }
    
    public boolean recognizes(String txt) {
        List<Integer> pc = new ArrayList<>();
        DirectedDFS dfs = new DirectedDFS(digraph, 0);
        for(int i = 0; i < digraph.getPointsCount(); i++) {
            if(dfs.marked(i)) {
                pc.add(i);
            }
        }
        for(int i = 0; i < txt.length(); i++) {
            List<Integer> match = new ArrayList<>();
            for(int ele : pc) {
                if(ele < length) {
                    if(re[ele] == txt.charAt(i) || re[ele] == '.') {
                        match.add(ele + 1);
                    }
                }
            }
            pc = new ArrayList<>();
            dfs = new DirectedDFS(digraph, match);
            for (int j = 0; j < digraph.getPointsCount(); j++) {
                if(dfs.marked(j)) {
                    pc.add(j);
                }
            }
        }
        for(int i : pc) {
            if(i == length) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        NFA nfa = new NFA("ab*");
        System.out.println(nfa.recognizes("a"));
    }
}
