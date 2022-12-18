package com.coursera.algo1.week1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        QuickFindUF uf = new QuickFindUF(N);
        while (sc.hasNext())
        {
            int p = sc.nextInt();
            int q = sc.nextInt();
            if (!uf.isConnnected(p, q))
            {
                uf.union(p, q);
                System.out.println(p + " " + q);
            }
        }
    }
}
