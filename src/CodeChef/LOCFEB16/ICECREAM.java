package CodeChef.LOCFEB16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 27-2-16.
 */
public class ICECREAM {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        final double PIE = 3.141592653589;
        int t = in.nextInt();
        while (t > 0) {
            t--;
            double r1 = in.nextDouble(), h1 = in.nextDouble(), r2 = in.nextDouble(), h2 = in.nextDouble();
            double cone = (PIE * r1 * r1) * (h1 + 2 * r1) / 3, cylinder = PIE * r2 * r2 * h2;
            out.printf("%.9f ", cone);
            out.printf("%.9f\n", cylinder);
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