package CodeChef.MARCH17;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 3/4/2017.
 */
public class XENTASK {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            int sum1 = 0;
            int sum2 = 0;
            int n = in.nextInt();
            if (n == 1) {
                sum1 = in.nextInt();
                sum2 = in.nextInt();

            } else if (n % 2 == 0) {
                for (int i = 0; i < n/2; i++) {
                    sum1 += in.nextInt();
                    sum2 += in.nextInt();
                }
                for (int i = 0; i < n/2; i++) {
                    sum2 += in.nextInt();
                    sum1 += in.nextInt();
                }
            } else {
                sum1 += in.nextInt();
                for (int i = 0; i < n/2; i++) {
                    sum2 += in.nextInt();
                    sum1 += in.nextInt();
                }
                sum2 += in.nextInt();
                for (int i = 0; i < n/2; i++) {
                    sum1 += in.nextInt();
                    sum2 += in.nextInt();
                }
            }

            if (sum1 > sum2) {
                out.println(sum2);
            } else {
                out.println(sum1);
            }

        } while (--t > 0);
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
