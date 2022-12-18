package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule();
        int[][] prerequisites = {{1,2},{2,3},{3,0},{2,0}};
        System.out.println(solution.canFinish(4,prerequisites));
    }

    /*
4 - [1,2],[2,3],[1,3],[0,2]

4 - [1,2],[2,3],[3,1],[0,2]

*/
    private boolean canFinish;
    private static final int WHITE = 0, GRAY = 1, BLACK = 2;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new List[numCourses];
       // Arrays.fill(adjList, new ArrayList<Integer>());

        for(int[] prerequisite: prerequisites){
            if(adjList[prerequisite[1]] == null){
                adjList[prerequisite[1]] = new ArrayList<>();
            }
            adjList[prerequisite[1]].add(prerequisite[0]);
        }

        int[] visited = new int[numCourses];
        canFinish = true;
        for(int i=0; i<numCourses && canFinish; i++){
            if(visited[i] == WHITE){
                dfs(adjList,visited,i);
            }
        }
        return canFinish;
    }

    private void dfs(List<Integer>[] adjList, int[] visited, int i) {
        if(visited[i] == GRAY){
            canFinish = false;
        }else if(visited[i] == WHITE){
            visited[i] = GRAY;
            List<Integer> adj = adjList[i];
            if(adj != null){
                for(int j: adj){
                    dfs(adjList,visited,j);
                }
            }
            visited[i] = BLACK;
        }
    }
}
