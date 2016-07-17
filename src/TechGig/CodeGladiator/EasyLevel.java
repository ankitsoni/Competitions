package TechGig.CodeGladiator;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 30-3-16.
 */
public class EasyLevel {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        int l = in.nextInt();
        int p = 1, i = 0;
        int[] count = new int[n + 1];
        count[p]++;
        while (true) {
            p = count[p] % 2 == 0 ? p + l : p - l;
            if (p < 1)
                p = n + p ;
            if (p > n)
                p = p - n;
            count[p]++;i++;
            if (count[p] == m)
                break;
        }
        out.println(i);
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
