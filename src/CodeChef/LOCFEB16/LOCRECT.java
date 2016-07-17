package CodeChef.LOCFEB16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 27-2-16.
 */
public class LOCRECT {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t > 0) {
            t--;
            int l1 = in.nextInt(), w1 = in.nextInt(), l2 = in.nextInt(), w2 = in.nextInt();
            int maxArea = (l1 * w1) + (l2 * w2);
            int p = l1 > l2 ? l2 : l1, q = w1 > w2 ? w2 : w1;
            int minArea = maxArea - (p*q);
            out.print(minArea+" ");
            out.print(maxArea+"\n");
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

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }
}
