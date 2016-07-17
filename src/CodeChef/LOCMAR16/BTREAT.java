package CodeChef.LOCMAR16;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by asoni on 25-3-16.
 */
public class BTREAT {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            int N = in.nextInt();
            int[] c = new int[N];
            long sum = 0;
            for (int i = 0; i < N; i++) {
                c[i] = in.nextInt();
                sum = sum + c[i];
            }
            if (sum % ((long) N) != 0) {
                out.println("No Treat");
            } else {
                long avg = (sum / N);
                long tasks = 0;
                for (int i = 0; i < N; i++) {
                    tasks = (c[i] > (int)avg) ? tasks + c[i] - (int)avg : tasks;
                }
                out.println(tasks);
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

