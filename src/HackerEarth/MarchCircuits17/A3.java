package HackerEarth.MarchCircuits17;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 3/22/2017.
 */
public class A3 {
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
        }
        int[] u = new int[m];
        int[] v = new int[m];
        int[] c = new int[m];
        for (int i = 0; i < m; i++) {
            u[i] = in.nextInt();
            v[i] = in.nextInt();
            c[i] = in.nextInt();
        }
//        int[][] ans = solve();
//        print(ans, n, m);
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

