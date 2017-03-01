package HackerEarth.BuyHatke;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by asoni on 2/5/2017.
 */
public class A1 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] preferPos = new int[n];
        for (int i = 0; i < n; i++) {
            preferPos[i] = in.nextInt();
        }
        out.println(solve(n, m, k, preferPos));
        out.close();
    }

    static int solve(int n, int m, int k, int[] preferPos) {
        int[] free = new int[m + 1];
        int unLucky = 0;
        for (int i = 1; i <= m; i++) {
            free[i] = k;
        }
        for (int i = 0; i < n; i++) {
            if (free[preferPos[i]] > 0) {
                free[preferPos[i]]--;
            } else {
                unLucky++;
                if (i > (m * k) - 1) {
                    continue;
                }
                int index = preferPos[i] == m ? 1 : preferPos[i] + 1;
                for (int j = index; j <= m && j != preferPos[i]; j++) {
                    if (free[j] > 0) {
                        free[j]--;
                        break;
                    }
                    if (j == m) {
                        j = 0;
                        continue;
                    }
                }
            }
        }
        return unLucky;
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

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}
