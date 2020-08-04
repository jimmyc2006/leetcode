package shuwei.leetcode.cn.two.zero.seven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    ArrayList[] graph = new ArrayList[numCourses];
    for(int i=0;i<numCourses;i++){
      graph[i] = new ArrayList<>();
    }
    for( int[]arr : prerequisites){
      graph[arr[1]].add(arr[0]);
    }
    int [] visited = new int[numCourses];

    for(int i=0;i<numCourses;i++){
      if(visited[i]==0 &&  !dfsVisit(i, graph, visited)){
        return false;
      }
    }
    return true;
  }

  boolean dfsVisit(int i, ArrayList[] graph,int[] visited){
    visited[i] =1;
    ArrayList<Integer> neighbours = graph[i];
    for(int j=0;j<neighbours.size();j++){
      int neigh = neighbours.get(j);
      if(visited[neigh]==1){
        return false;
      }
      if(visited[neigh]==0 && !dfsVisit(neigh, graph,visited)){
        return false;
      }
    }
    visited[i]=2;
    return true;
  }

//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//      if (prerequisites == null || prerequisites.length < 1) {
//        return true;
//      }
//      status = new int[numCourses];
//      Map<Integer, List<Integer>> afterMap = new HashMap<>();
//      for (int[] before : prerequisites) {
//        if (before.length < 1) {
//          continue;
//        }
//        List<Integer> afters = afterMap.computeIfAbsent(before[1], k -> new ArrayList<>());
//        afters.add(before[0]);
//      }
//      for (Integer key : afterMap.keySet()) {
//        if (!dfs(key, afterMap)) {
//          return false;
//        }
//      }
//      return true;
//  }
//  int[] status;
//  private boolean dfs(Integer key, Map<Integer, List<Integer>> afterMap) {
//    if (status[key] == 1) {
//      return false;
//    } else if (status[key] == 0) {
//      status[key] = 1;
//      List<Integer> after = afterMap.get(key);
//      if (after != null) {
//        for (Integer ele : after) {
//          if (!dfs(ele, afterMap)) {
//            return false;
//          }
//        }
//      }
//      status[key] = 2;
//    }
//    return true;
//  }

//  public boolean canFinish1(int numCourses, int[][] prerequisites) {
//    if (prerequisites == null || prerequisites.length < 1) {
//      return true;
//    }
//    int[] courses = new int[numCourses];
//    Map<Integer, List<Integer>> afterMap = new HashMap<>();
//    for (int[] before : prerequisites) {
//      if (before.length < 1) {
//        continue;
//      }
//      courses[before[0]]++;
//      List<Integer> afters = afterMap.computeIfAbsent(before[1], k -> new ArrayList<>());
//      afters.add(before[0]);
//    }
//    Queue<Integer> queue = new LinkedList<>();
//    for (int key : afterMap.keySet()) {
//      if (courses[key] == 0) {
//        queue.add(key);
//      }
//    }
//    int aa = 0;
//    while (!queue.isEmpty()) {
//      int size = queue.size();
//      for (int i = 0; i < size; i++) {
//        Integer poll = queue.poll();
//        List<Integer> aft = afterMap.get(poll);
//        if (aft != null) {
//          aa++;
//          for (int ele : aft) {
//            courses[ele]--;
//            if (courses[ele] <= 0) {
//              queue.add(ele);
//            }
//          }
//        }
//      }
//    }
//    return aa == afterMap.size();
//  }
}
