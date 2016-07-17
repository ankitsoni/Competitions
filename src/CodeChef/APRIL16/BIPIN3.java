package CodeChef.APRIL16;

import java.io.*;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Created by asoni on 4-4-16.
 */
public class BIPIN3 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            int n = in.nextInt();
            int k = in.nextInt();
            long result = k;
            long tempResult = 0l;
            for (int i = 1; i < n - 1; i = ((i << 1) | 1 )) {
                result = result * result ;
                if (result> 1000000007)
                    result = result % 1000000007;
            }
            out.println(result);
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




