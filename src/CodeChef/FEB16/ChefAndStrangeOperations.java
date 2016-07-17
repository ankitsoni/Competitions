package CodeChef.FEB16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by asoni on 11-2-16.
 * url : https://www.codechef.com/FEB16/problems/STROPR
 */
public class ChefAndStrangeOperations {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int T = in.nextInt();
        while (T > 0) {
            int N = in.nextInt();
            int x = in.nextInt();
            int M = in.nextInt();
            int[] a = new int[N];

            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
            }

            for (int i = x; i < N; i++) {

            }

            T--;
        }
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

    }
}
