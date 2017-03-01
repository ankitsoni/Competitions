package HackerRank.Zapr;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 2/25/2017.
 */
public class A1 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        String[] num = new String[t];
        for (int i = 0; i < t; i++) {
            num[i] = in.next();
        }
        String k = solve(num);
        out.close();
    }

    static String solve(String[] tests) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tests.length; i++) {
            long n = Long.valueOf(tests[i]);
            long k = n;
            long l = 1;
            int pow = 0;
            if (n == 1) {
                sb.append("Clark\n");
                continue;
            }

            while (k != 1) {
                k = k >> 1;
                l = l << 1;
                pow++;
            }
            if(n==l)
                pow--;
            if (pow % 2 != 0)
                sb.append("Clark\n");
            else
                sb.append("Bruce\n");
        }
        return sb.toString();
    }
//    1 clark
//    2 b
//    3 c
//    4 c
//    5 b
//    6 b
//    7 b
//    8 b
//    9 c

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
