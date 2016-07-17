package SPOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by asoni on 28-2-16.
 */
public class PRIME1 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            StringBuilder sb = new StringBuilder();
            int m = in.nextInt();
            int n = in.nextInt();
            for (int i = 0; i < n - m + 1; i++) {
                int sroot = (int) Math.sqrt(m + i);
                if ((m + i) == 2 || (m + i) == 3) {
                    sb.append(m+i+"\n");
                }
                for (int j = 2; j <= sroot; j++) {
                    if ((m + i) % j == 0) {
                        break;
                    }
                    if (j == sroot)
                        sb.append(m+i+"\n");
                }
            }
            out.println(sb);
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
