package HackerEarth.MarchCircuits17;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 3/21/2017.
 */
public class A1 {
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] f = new int[2 * m + 1][2 * m + 1];
        for (int i = 0; i < (2 * m + 1); i++) {
            for (int j = 0; j < (2 * m + 1); j++) {
                f[i][j] = in.nextInt();
            }
        }
        int[][] g = new int[n + 2 * m][n + 2 * m];
        for (int i = m; i < n + m; i++) {
            for (int j = m; j < n + m; j++) {
                g[i][j] = in.nextInt();
            }
        }
        int[][] ans = solve(f, g, n, m);
        print(ans, n, m);
        out.close();
    }

    static void print(int[][] g, int n, int m) {
        for (int i = m; i < n + m; i++) {
            for (int j = m; j < n + m; j++) {
                out.print(g[i][j] + " ");
            }
            out.println();
        }
    }

    static int[][] solve(int[][] f, int[][] g, int n, int m) {
        int[][] ans = new int[n + 2 * m][n + 2 * m];
        for (int i = m; i < n + m; i++) {
            for (int j = m; j < n + m; j++) {
                int sum = 0;
                for (int k = 0; k < 2 * m + 1; k++) {
                    for (int l = 0; l < 2 * m + 1; l++) {
                        sum += f[k][l] * g[i + k - m][j + l - m];
                    }
                }
                ans[i][j] = sum;
            }
        }
        return ans;
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
