package Google.CodeJam8April2016;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by asoni on 9-4-16.
 */
public class CoinJam {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        int counter = 1;
        do {
            int n = in.nextInt();
            int j = in.nextInt();
            double range = Math.pow(2,n);
            StringBuilder[] sb = new StringBuilder[((int) range)];
            for (int i = 0; i < sb.length; i++) {
                sb[i] = new StringBuilder("1");
            }
            //sb = createString(sb,n);
            BigInteger bi = new BigInteger("123456789123456789009876543210788");
            out.println("Case #" + (counter++) + ": " + bi);
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







