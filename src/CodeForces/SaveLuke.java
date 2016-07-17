package CodeForces;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 14-2-16.
 * http://codeforces.com/contest/624/problem/A
 * Correct
 */
public class SaveLuke {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int d = in.nextInt();
        int L = in.nextInt();
        int v1 = in.nextInt();
        int v2 = in.nextInt();
        double ans = ((((double) L)-d)/(v1+v2));
        out.printf("%.20f",ans);
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

    }
}
