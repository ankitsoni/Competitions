package CodeChef.LOCMAR16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 27-3-16.
 */
public class FRAC {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        double[] c = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int maxPos =0;
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
            c[i] = (a[i]*1.0)/b[i];
            if((int)Math.ceil(c[maxPos] - c[i]) < 1)
                maxPos = i;
        }
        out.printf("%.6f",c[maxPos]);
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


