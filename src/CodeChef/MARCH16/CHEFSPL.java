package CodeChef.MARCH16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 5-3-16.
 */
public class CHEFSPL {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            String string = in.next();
            int strLength = string.length();
            char c = '0';
            int oddCount = 0;
            int[] strCharArray = new int[26];
            if (strLength < 2) {
                out.println("NO");
                continue;
            } else if (strLength == 2) {
                if (string.charAt(0) == string.charAt(1)) {
                    out.println("Yes");
                    continue;
                } else {
                    out.println("NO");
                    continue;
                }
            }

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