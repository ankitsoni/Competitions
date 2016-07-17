package HackerEarth.practice.algorithms.dynamic_programming;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 27-6-16.
 */
public class XsquareAndChocolatesBars2 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        try{
            int t = in.nextInt();
            String bar = in.next();
            do {
                long res = solve(bar);
                out.println(res);
            } while (--t > 0);
        }catch (Exception e){
            e.printStackTrace();
        }
        out.close();
    }

    static long solve(String bar){
        long res =0;
        return res;
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




