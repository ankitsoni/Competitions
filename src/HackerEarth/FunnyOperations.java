package HackerEarth;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 21-2-16.
 * url: https://www.hackerearth.com/chipmonk-hiring-challenge/problems/16a0ddf47a454fdf8d1da94881f9f5ca/
 */
public class FunnyOperations {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t > 0) {
            t--;
            int n = in.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
            }
            long xor = 0, and = 0;
            int i = 0;
            for (i = 0, xor = arr[i], and = arr[i]; i < n - 1; i++) {
                xor = xor ^ arr[i + 1];
                and = and & arr[i + 1];
            }

            long or = xor | and;
            long temp = or;
            int count = 0;
            while (temp > 0) {
                temp = temp >> 1;
                count++;
            }
            out.print(or);
            out.print(" ");
            out.print(count);
        }
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

    }
}
