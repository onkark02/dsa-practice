package practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NetworkDelayTIme {
    private List<Edge>[] adjList;
    private int[] weights;
    private void init(int[][] times, int n){
        adjList = new List[n+1];
        weights = new int[n+1];
        for(int[] time: times){
            int source = time[0];
            Edge edge = new Edge(time[1],time[2]);
            List<Edge> list = adjList[source];
            if(list == null)
                list = new ArrayList<>();
            list.add(edge);
            adjList[source] = list;
        }
        Arrays.fill(weights, Integer.MAX_VALUE);
        weights[0] = -1;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        init(times, n);
        dfs(k,0);
        int maxWeight=0;
        for(int i=1; i<=n; i++){
            if(weights[i] == Integer.MAX_VALUE)
                return -1;
            if(weights[i] > maxWeight){
                maxWeight = weights[i];
            }
        }
        return maxWeight;
    }

    private void dfs(int k, int weight){
        if(weights[k] > weight){
            weights[k] = weight;
            List<Edge> edges = adjList[k];
            if(edges != null){
                for(Edge edge: edges){
                    dfs(edge.dest, weight+edge.weight);
                }
            }
        }
    }

    class Edge{
        int dest;
        int weight;
        public Edge(int dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {

        String str = "32...423.4";
        str.split(".");
        System.out.println();
/*        NetworkDelayTIme solution = new NetworkDelayTIme();
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(solution.networkDelayTime(times,4,2));*/
    }

}
