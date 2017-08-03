package HackerEarth.MarchCircuits17;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 3/22/2017.
 */
public class A2 {
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        int[][] ans = solve(matrix, n, m);
        print(ans, n);
        out.close();
    }

    static void print(int[][] g, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(g[i][j] + " ");
            }
            out.println();
        }
    }

    static int[][] solve(int[][] f, int n, int m) {
        long extra = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                extra += f[i][j];
            }
        }
        extra -= n * n;
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = 1;
            }
        }
        for (int sum = 2 * (n - 1); sum >= 0; sum--) {
            // 3 9 1 2 3 6 7 9 2 1 5
            for (int j = sum >= n ? n - 1 : sum; j >= 0; j--) {
                for (int k = sum - j; k < n; k++) {
                    if (ans[j][k] != m) {
                        if (extra >= (m - 1)) {
                            extra = extra - (m - 1);
                            ans[j][k] = m;
                        } else {
                            ans[j][k] += extra;
                            return ans;
                        }
                    }
                }
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

//5 9
//        1 2 3 4 5
//        4 7 8 5 2
//        1 4 5 6 2
//        1 2 1 2 1
//        9 9 1 1 1

