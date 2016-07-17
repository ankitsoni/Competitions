package CodeChef.FEB16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 10-2-16.
 * url : https://www.codechef.com/FEB16/problems/CHEFDETE
 * Correct
 */
public class ChefDetective {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int N = in.nextInt();
        int[] a = new int[N + 1];
        int[] b = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 1; i < N + 1; i++) {
            if (a[i] != 0) {
                b[a[i]] = -1;
            }
        }
        for (int i = 1; i < N + 1; i++) {
            if (b[i] != -1) {
                out.println(i);
//                System.out.printf("%d ",i);
            }
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

    }
}
