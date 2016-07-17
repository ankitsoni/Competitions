package CodeChef.COOK67;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 21-2-16.
 */
public class TUZGMBR {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        int X = 0, Y = 0, xdiff = 0, ydiff = 0, sumDiff = 0;
        String string;
        int result;
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        string = in.next();
        for (int i = 0; i < m; i++,sumDiff=0) {
            char c = string.charAt(i);
            switch (c) {
                case 'R':
                    X++;
                    break;
                case 'L':
                    X--;
                    break;
                case 'D':
                    Y--;
                    break;
                case 'U':
                    Y++;
                    break;
            }
            for (int j = 0; j < n ; j++) {
                xdiff = X - x[j];
                ydiff = Y - y[j];
                if (xdiff < 0)
                    xdiff = xdiff * (-1);
                if (ydiff < 0)
                    ydiff = ydiff * (-1);
                sumDiff = sumDiff + xdiff + ydiff;
            }
            sb.append(sumDiff);
            sb.append("\n");
        }
        System.out.println(sb);
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
