package com.coursera.algotoolbox.ds.week1;

import java.util.*;
import java.io.*;

public class tree_height {
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

	public class TreeHeight {
		int n;
		int parent[];
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

		int computeHeight() {
            // Replace this code with a faster implementation
			Node[] nodes = new Node[n];
			Node root = null;
			for(int i=0; i<n; i++){
				nodes[i] = new Node(i);
			}
			for(int i=0; i<n; i++){
				if(parent[i] == -1){
					root = nodes[i];
				}else{
					nodes[parent[i]].addChild(nodes[i]);
				}
			}

			return getMaxHeight(root);
		}

		private int getMaxHeight(Node root){
			int height = 0;
			Queue<Node> queue = new LinkedList<>();
			if(root != null){
				queue.add(root);
			}
			while(!queue.isEmpty()){
				height++;
				int size = queue.size();
				for(int i=0; i<size; i++){
					Node node = queue.poll();
					queue.addAll(node.children);
				}
			}
			return height;
		}
	}

	private class Node {
    	int val;
    	List<Node> children;

    	public Node(int n){
    		this.val = n;
    		this.children = new ArrayList<>();
		}

		public void addChild(Node node){
    		this.children.add(node);
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
