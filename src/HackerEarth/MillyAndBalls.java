package HackerEarth;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 21-2-16.
 * url : https://www.hackerearth.com/chipmonk-hiring-challenge/problems/e6d232a8bd3c49f8969b65abb02e858b/
 * 60% correct
 */
public class MillyAndBalls {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t > 0) {
            t--;
            int N = in.nextInt();
            int K = in.nextInt();
            long ballsRequired = 1L*(N * (N + 1)) / 2;
            long P;
            if (K <= ballsRequired) {
                P = ballsRequired - K;
            } else {
                long temp = K % ballsRequired;
                if(temp == 0)
                    P = 0;
                P = ballsRequired - temp;
            }
            out.println(P);
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
