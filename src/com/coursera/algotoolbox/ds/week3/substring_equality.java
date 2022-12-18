package com.coursera.algotoolbox.ds.week3;

import java.util.*;
import java.io.*;

public class substring_equality {
	public class Solver {
		private final int m1 = 1000000007;
		private final int m2 = 1000000009;
		private final long x = 31;
		private String s;
		private int[] h1;
		private int[] h2;
		public Solver(String s) {
			this.s = s;
			h1 = new int[s.length()+1];
			h2 = new int[s.length()+1];
			populateHashArray();
		}
		private void populateHashArray(){
			for(int i=1; i<h1.length; i++){
				int s = this.s.charAt(i-1);
				long sum = h1[i-1]*x + s;
				h1[i] = (int) (sum % m1);
				sum = h2[i-1]*x + s;
				h2[i] =(int) (sum % m2);
			}
		}
		public boolean askNaive(int a, int b, int l){
			return s.substring(a,a+l).equals(s.substring(b,b+l));
		}

		public boolean ask(int a, int b, int l) {
			if(a==b){
				return true;
			}else{
				int aPrefixHash1, bPrefixHash1,aPrefixHash2,bPrefixHash2;
				long multiplier1 = power( x,l,m1);
				long multiplier2 = power( x,l,m2);
				aPrefixHash1 =  (int) (h1[a+l] - h1[a]*multiplier1%m1 + m1) % m1;
				aPrefixHash2 = (int) ( h2[a+l] - h2[a]*multiplier2%m2 + m2) % m2;

				bPrefixHash1 = (int) (  h1[b+l] - h1[b]*multiplier1%m1 + m1) % m1;
				bPrefixHash2 = (int) ( h2[b+l] - h2[b]*multiplier2%m2 + m2) % m2;

				return (aPrefixHash1==bPrefixHash1) && (aPrefixHash2==bPrefixHash2);
			}
		}

		private long power(long val, int y, int p)
		{
			long res = 1; // Initialize result
			if(p==0)
				return 1;
			val = val % p; // Update x if it is more than or
			// equal to p

			if (val == 0)
				return 0; // In case x is divisible by p;

			while (y > 0)
			{

				// If y is odd, multiply x with result
				if ((y & 1) != 0)
					res = (res * val) % p;

				// y must be even now
				y = y >> 1; // y = y/2
				val = (val * val) % p;
			}
			return res;
		}
	}

	public void run() throws IOException {
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		String s = in.next();
		int q = in.nextInt();
		Solver solver = new Solver(s);
		for (int i = 0; i < q; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int l = in.nextInt();
			out.println(solver.ask(a, b, l) ? "Yes" : "No");
		}
		out.close();
	}

	static public void main(String[] args) throws IOException {
	    new substring_equality().loadTest();

	}

	public void loadTest(){
		String str = "try real stuff which is the stuff for the real as try try but not cry cry";
		Solver s = new Solver(str);
		int len = str.length();
		while(true){
			int a = new Random().nextInt(len);
			int b= new Random().nextInt(len);
			int l = new Random().nextInt(len);
			if(a+l >= len || b+l >= len)
				continue;
			boolean askAns = s.ask(a,b,l);
			boolean askNaiveAns = s.askNaive(a,b,l);
			if(askAns == askNaiveAns){
				System.out.println(String.format("a: %d, b: %d, l: %d", a,b, l));
				/*if(askAns && a != b && l>2){
					System.out.println(String.format("a: %d, b: %d, l: %d", a,b, l));
					System.out.println(str.substring(a,a+l) + "--" + str.substring(b,b+l));
				}*/
					System.out.println(askAns + "--" + askNaiveAns);
				System.out.println(str.substring(a,a+l) + "--" + str.substring(b,b+l));
			}else{
				System.out.println(String.format("a: %d, b: %d, l: %d", a,b, l));
				break;
			}
		}
	}

	class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}
}
