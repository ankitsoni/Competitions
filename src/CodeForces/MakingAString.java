package CodeForces;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 14-2-16.
 * url : http://codeforces.com/contest/624/problem/B
 * Correct
 */
public class MakingAString {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        long[] a = new long[n];
        long sum = 0;
        List list = new ArrayList<Long>();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
            while (list.contains(a[i])) {
                a[i]--;
            }
            if (a[i] >= 1) {
                list.add(a[i]);
                sum = sum + a[i];
            }
        }
        out.print(sum);
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
        public long nextLong(){ return Long.parseLong(next());}

    }
}
