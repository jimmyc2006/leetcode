package shuwei.leetcode.cn.mst.unknown;

import java.util.*;

public class Solution {

    private final char in = 'S';
    private final char out = 'T';
    private final char ban = '#';
    private final char stones = 'O';
    private final char trap = 'M';

    private char[][] cMaze;

    // ["S#O", "M..", "M.T"]
    public int minimalSteps(String[] maze) {
        long startTime = System.currentTimeMillis();
        cMaze = new char[maze.length][];
        for (int i = 0; i < maze.length; i++) {
            cMaze[i] = maze[i].toCharArray();
        }
        // 收集石头堆和陷阱信息
        Set<Point> stoneSet = new HashSet<>();
        trapsList = new ArrayList<>();
        Point start = null, end = null;
        for (int i = 0; i < cMaze.length; i++) {
            for (int j = 0; j < cMaze[i].length; j++) {
                switch (cMaze[i][j]) {
                    case in:
                        start = new Point(i, j);
                        break;
                    case out:
                        end = new Point(i, j);
                        break;
                    case stones:
                        stoneSet.add(new Point(i, j));
                        break;
                    case trap:
                        trapsList.add(new Point(i, j));
                        break;
                    default:
                        break;
                }
            }
        }
        // 没有陷阱，直接返回入口到出口距离
        if (trapsList.isEmpty()) {
            Map<Point, Integer> tmp = this.bfsStonesDistances(start, Arrays.asList(end));
            if (tmp == null) {
                return -1;
            } else {
                return tmp.get(end) == null ? -1 : tmp.get(end);
            }
        }
        Map<Point, Integer> in2StrapCount = this.bfsStonesDistances(start, trapsList);
        if (in2StrapCount.keySet().size() < trapsList.size()) {
            return -1;
        }
        Map<Point, Map<Point, Integer>> trap2StoneMap = new HashMap<>();
        Set<Point> goodStoneSet = new HashSet<>();
        for (Point trap : trapsList) {
            Map<Point, Integer> stoneDistanceMap = bfsStonesDistances(trap, stoneSet);
            if (stoneDistanceMap.isEmpty()) {
                return -1;
            } else {
                trap2StoneMap.put(trap, stoneDistanceMap);
                if (goodStoneSet.isEmpty()) {
                    goodStoneSet.addAll(stoneDistanceMap.keySet());
                }
            }
        }
        Map<Point, Integer> inStonesMap = bfsStonesDistances(start, goodStoneSet);
        if (inStonesMap.isEmpty()) {
            return -1;
        }
        outTrapMap = bfsStonesDistances(end, trapsList);
        if (outTrapMap.isEmpty()) {
            return -1;
        }
        // in to trap to strap ... to strap to end
        // in to traps
        in2StrapDistance = new HashMap<>();
        for (Point trap : trapsList) {
            int distance = Integer.MAX_VALUE;
            for (Point stone : goodStoneSet) {
                distance = Math.min(distance, inStonesMap.get(stone) + trap2StoneMap.get(trap).get(stone));
            }
            in2StrapDistance.put(trap, distance);
        }
        trap2StrapDistance = new HashMap<>();
        for (Point startTrap : trapsList) {
            Map<Point, Integer> map = new HashMap<>();
            trap2StrapDistance.put(startTrap, map);
            for (Point endTrap : trapsList) {
                if (!endTrap.equals(startTrap)) {
                    int minDis = Integer.MAX_VALUE;
                    for (Point stone : goodStoneSet) {
                        minDis = Math.min(minDis, trap2StoneMap.get(startTrap).get(stone) + trap2StoneMap.get(endTrap).get(stone));
                    }
                    map.put(endTrap, minDis);
                }
            }
        }
        // in totraps to end
        int ans = Integer.MAX_VALUE;
        index = new int[trapsList.size()];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        if (index.length == 1) {
            return in2StrapDistance.get(trapsList.get(0)) + outTrapMap.get(trapsList.get(0));
        }
        minVCache = new HashMap<>();
        System.out.println("::::" + (System.currentTimeMillis() - startTime));
        times = 0;
        return dfs(0, 0, -1);
    }

    private int times;
    Map<Point, Integer> in2StrapDistance;
    Map<Point, Integer> outTrapMap;
    Map<Point, Map<Point, Integer>> trap2StrapDistance;
    List<Point> trapsList;
    int[] index;
    Map<String, Integer> minVCache;
    private int minValue = Integer.MAX_VALUE;   // 剪枝

    private int dfs(int beforeSum, int level, int beforeIndex) {
        times++;
        if (beforeSum >= minValue){
//            System.out.println(beforeSum + " :: " + minValue + "::" + times++);
            return Integer.MAX_VALUE;
        }
        String key = this.genIndexKey(beforeIndex);
        if (minVCache.get(key) != null) {
            return minVCache.get(key) + beforeSum;
        }
        int minDis = Integer.MAX_VALUE;
        if (level == 0) {
            for (int i = 0; i < index.length; i++) {
                index[i] = -1;
                int dis = dfs(in2StrapDistance.get(trapsList.get(i)), level + 1, i);
                minDis = Math.min(minDis, dis);
                minValue = minDis;
                index[i] = i;
            }
            return minDis;
        } else if (level == index.length - 1) {
            for (int i = 0; i < index.length; i++) {
                if (index[i] >= 0) {
                    minDis = beforeSum + trap2StrapDistance.get(trapsList.get(i)).get(trapsList.get(beforeIndex)) + outTrapMap.get(trapsList.get(i));
                    return minDis;
                }
            }
            return minDis;
        } else {
            for (int i = 0; i < index.length; i++) {
                if (index[i] == i) {
                    index[i] = -1;
                    int thisDis = dfs(beforeSum + trap2StrapDistance.get(trapsList.get(i)).get(trapsList.get(beforeIndex)), level + 1, i);
                    minDis = Math.min(minDis, thisDis);
                    index[i] = i;
                }
            }
            if (minDis != Integer.MAX_VALUE) {
                minVCache.put(key, minDis - beforeSum);
            }
            return minDis;
        }
    }

    private String genIndexKey(int beforeIndex) {
        StringBuilder result = new StringBuilder();
        result.append("[" + beforeIndex +"]");
        for (Integer i : index) {
            result.append("[" + i + "]");
        }
        return result.toString();
    }

    private Map<Point, Integer> bfsStonesDistances(Point start, Collection<Point> ends) {
        Map<Point, Integer> resultMap = new HashMap<>();
        int[][] distances = new int[cMaze.length][cMaze[0].length];
        for (int i = 0; i < distances.length; i++) {
            Arrays.fill(distances[i], cMaze.length * cMaze[0].length + 1);
        }
        int currDistance = 0;
        LinkedList<Point> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                Point point = queue.pop();
                if (cMaze[point.x][point.y] != ban && distances[point.x][point.y] > currDistance) {
                    distances[point.x][point.y] = currDistance;
                    if (ends.contains(point)) {
                        resultMap.put(point, currDistance);
                        if (resultMap.size() == ends.size()) {
                            return resultMap;
                        }
                    }
                    if (point.x - 1 >= 0) {
                        queue.add(new Point(point.x - 1, point.y));
                    }
                    if (point.x + 1 < cMaze.length) {
                        queue.add(new Point(point.x + 1, point.y));
                    }
                    if (point.y - 1 >= 0) {
                        queue.add(new Point(point.x, point.y - 1));
                    }
                    if (point.y + 1 < cMaze[0].length) {
                        queue.add(new Point(point.x, point.y + 1));
                    }
                }
            }
            currDistance++;
        }
        return resultMap;
    }

    public <T> void listAll(T[] t) {
        allArray.clear();
        listAll0(Arrays.asList(t), new LinkedList<>());
    }

    List allArray = new ArrayList<>();

    private <T> void listAll0(List<T> l, LinkedList<T> prefix) {
        if (l.isEmpty()) {
            allArray.add(new ArrayList(prefix));
            return;
        }
        for (int i = 0; i < l.size(); i++) {
            List<T> temp = new LinkedList<T>(l);
            prefix.add(temp.remove(i));
            listAll0(temp, prefix);
            prefix.removeLast();
        }
    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
