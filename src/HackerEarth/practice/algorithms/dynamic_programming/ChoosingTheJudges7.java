package HackerEarth.practice.algorithms.dynamic_programming;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 28-6-16.
 */
public class ChoosingTheJudges7 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        try{
            int counter=1;
            int t = in.nextInt();
            do {
                int n = in.nextInt();
                int[] x = new int[n];
                for (int i = 0; i < n; i++) {
                    x[i] = in.nextInt();
                }
                long res = solve(x,n);
                out.println("Case "+ counter++ +": "+res);
            } while (--t > 0);
        }catch (Exception e){
            e.printStackTrace();
        }
        out.close();
    }

    static long solve(int[] x,int n){
        long[] sum = new long[n];
        sum[0]= x[0];
        if(n>1){
            sum[1] = sum[0]>x[1] ? x[0] : x[1];
        }
        for (int i = 2; i < n; i++) {
            if(sum[i-2]+x[i]>sum[i-1])
                sum[i] = sum[i-2]+x[i];
            else
                sum[i] = sum[i-1];
        }
        return sum[n-1];
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

