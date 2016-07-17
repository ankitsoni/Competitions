package HackerEarth;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 28-2-16.
 * url : https://www.hackerearth.com/accolite-java-hiring-challenge/problems/ec9a9acef17c46adb8cc7f49abd2ca3c/
 */
public class ProductSquare {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int N = in.nextInt();
        int[] arr = new int[N];
        Set<Integer> integers = new HashSet<Integer>();
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
            integers.add(arr[i]);
        }
        long total = N*(N-1);
        int count =0;
        double root=0.0;

        out.printf("%.6f",2.0*count/total);
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}


