package CodeChef.LOCFEB16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 27-2-16.
 */
public class CHOCOLAT {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t > 0) {
            t--;
            int N = in.nextInt();
            int M = in.nextInt();
            if (N == M)
                out.printf("No Winner\n");
            else if (N > M)
                out.printf("Bipin %d\n", N - M);
            else
                out.printf("Balaji %d\n", M - N);
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