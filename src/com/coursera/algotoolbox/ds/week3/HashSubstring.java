package com.coursera.algotoolbox.ds.week3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HashSubstring {
    private static final int PRIME_NUMBER = 1000000007;
    private static final int MULTIPLIER =31;
    private static FastScanner in;
    private static PrintWriter out;

    public static void main(String[] args) throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        printOccurrences(getOccurrences(readInput()));
        out.close();
    }

    private static Data readInput() throws IOException {
        String pattern = in.next();
        String text = in.next();
        return new Data(pattern, text);
    }

    private static void printOccurrences(List<Integer> ans) throws IOException {
        for (Integer cur : ans) {
            out.print(cur);
            out.print(" ");
        }
    }

    private static List<Integer> getOccurrences(Data input) {
        String s = input.pattern, t = input.text;
        int m = s.length(), n = t.length();
        List<Integer> occurrences = new ArrayList<Integer>();

        int patternHash = getHashCode(s,0,m-1);
        int[] textHash = getHashCodeArr(t,m);
        for (int i = 0; i < textHash.length; ++i) {
            if(textHash[i] != patternHash)
                continue;;
	    boolean equal = true;
	    for (int j = 0; j < m; ++j) {
		if (s.charAt(j) != t.charAt(i + j)) {
		     equal = false;
 		    break;
		}
	    }
            if (equal)
                occurrences.add(i);
	}
        return occurrences;
    }

    private static int getHashCode(String str, int start, int end){
        int hash=0;
        for(int i=end; i >=start; i--){
            long hashLong = (long) hash * MULTIPLIER + str.charAt(i);
            hash = (int) (hashLong % PRIME_NUMBER);
            if(hash < 0)
                hash += PRIME_NUMBER;
        }
        return hash;
    }

    private static int[] getHashCodeArr(String str, int pLength){
        int[] hashCodes = new int[str.length() - pLength + 1];
        long patternPower = 1;
        for(int i=0; i<pLength; i++){
            patternPower = (patternPower * MULTIPLIER) % PRIME_NUMBER;
        }
        hashCodes[hashCodes.length-1] = getHashCode(str,str.length()-pLength,str.length()-1);

        for(int i=hashCodes.length-2; i>=0; i--){
            long hash = (long) hashCodes[i + 1] *MULTIPLIER + str.charAt(i);
            hash -= (long) str.charAt(i + pLength) * patternPower;
            hash = hash % PRIME_NUMBER;
            if(hash < 0)
                hash += PRIME_NUMBER;
            hashCodes[i] = (int) hash;
           // hashCodes[i] = (hashCodes[i+1]*MULTIPLIER + str.charAt(i) - str.charAt(i+pLength)*(MULTIPLIER^pLength) + PRIME_NUMBER) % PRIME_NUMBER;
        }

        return hashCodes;
    }

    static class Data {
        String pattern;
        String text;
        public Data(String pattern, String text) {
            this.pattern = pattern;
            this.text = text;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

