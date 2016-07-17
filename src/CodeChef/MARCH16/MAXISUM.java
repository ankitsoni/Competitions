package CodeChef.MARCH16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 5-3-16.
 */
public class MAXISUM {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        String[] strings = new String[2];
        do {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            int[] mul = new int[n];
            for (int i = 0; i < n; i++) {
                a[i]= in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i]= in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                mul[i]= a[i]*b[i];
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

