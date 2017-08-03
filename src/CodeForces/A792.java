package CodeForces;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by asoni on 3/27/2017.
 */
public class A792 {
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int n = in.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = in.nextInt();
        }
        Arrays.sort(p);
        solve(n,p);
        out.close();
    }

    static void solve(int n,int[] p){
        int minD = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if((p[i] - p[i-1]) < minD){
                minD = p[i] - p[i-1];
                count = 1;
            }else if((p[i] - p[i-1]) == minD)
                count++;
        }
        out.println(minD+" "+count);
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

        public String line() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}

