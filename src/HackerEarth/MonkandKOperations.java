package HackerEarth;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 1/15/2017.
 */
public class MonkandKOperations {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            out.println(process(a, n, k));
        } while (--t > 0);
        out.close();
    }

    static int process(int[] a, int n, int k) {
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        if (n == k) {
            return 0;
        } else if (k == n - 1) {
            for (int i = 0; i < k + 1; i++) {
                if (a[i] > max) {
                    max = max2;
                    max = a[i];
                }
            }
            return max;
        } else if (k >= n / 2) {
            for (int i = 0; i < n; i++) {
                if (a[i] > max) {
                    max = max2;
                    max = a[i];
                } else if (a[i] > max2) {
                    max2 = a[i];
                }
            }
            return max*max2;
        }

        for (int i = 0; i < k + 1; i++) {
            if (a[i] > max) {
                max = max2;
                max = a[i];
            } else if (a[i] > max2) {
                max2 = a[i];
            }

            if (a[n - k] > max) {
                max = max2;
                max = a[n - k];
            } else if (a[n - k] > max2) {
                max2 = a[n - k];
            }
        }
        return max * max2;
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
