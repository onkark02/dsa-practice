package com.coursera.algo1.week1;

/*Cost of operations
+------------+------------+-------+------+
| Algo       | initialize | union | find |
+------------+------------+-------+------+
| Quick-find | n          | n     | 1    |
+------------+------------+-------+------+

 Union operations- too expensive
n union operations will take n^2 operations
*/
public class QuickFindUF {
    private int[] id;

    //Set id of each object to itself
    public QuickFindUF(int n){
        id = new int[n];
        for(int i=0; i<n; i++)
            id[i]=i;
    }

    //check if p and q are connected i.e. in the same component
    public boolean isConnnected(int p, int q){
        return id[p]==id[q];
    }

    //Change all entries with id[p] to id[q]
    public void union(int p, int q){
        int pVal=id[p];
        int qVal=id[q];
        for(int i=0; i<id.length; i++)
            if(id[i]==pVal)
                id[i]=qVal;
    }
}
