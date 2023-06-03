package practice.dsa;

public class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int size){
        parent = new int[size];
        rank = new int[size];
        for(int i=0; i<size; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x){
        validateInput(x);
        if(parent[x] != x){
            parent[x] = find(parent[x]);

        }
        return parent[x];
    }

    public void union(int x, int y){
        int xParent = find(x), yParent = find(y);
        if(xParent != yParent){
            if(rank[xParent] > rank[yParent]){
                rank[xParent] += rank[yParent];
                parent[yParent] = xParent;
            }else{
                rank[yParent] += rank[xParent];
                parent[xParent] = yParent;
            }
        }//else no action is required
    }

    private void validateInput(int x){
        if(x >= parent.length || x < 0){
            throw new IllegalArgumentException("Input not valid");
        }
    }

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(10);
        unionFind.union(0,7);
        unionFind.union(0,8);
        unionFind.union(6,1);
        unionFind.union(2,0);
        unionFind.union(0,4);
        unionFind.union(5,8);
        unionFind.union(4,7);
        unionFind.union(1,3);
        unionFind.union(3,5);
        unionFind.union(6,5);
    }
}
