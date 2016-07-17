package CodeForces;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 28-2-16.
 * url : http://codeforces.com/contest/635/problem/B
 */
public class A365 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int sta0 = 0, des0 = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            if (a[i] == 0)
                sta0 = i;
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
            if (a[i] == 0)
                des0 = i;
        }
        int dis = sta0 >des0? sta0-des0:des0-sta0;
        if(dis==n-1)
            dis =0;

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
