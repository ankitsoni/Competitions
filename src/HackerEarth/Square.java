package HackerEarth;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 21-2-16.
 */
public class Square {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        int diffX = 0, diffY = 0, diffMax = 0, point1 = 0, point2 = 0;
        double diagonal2 = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                diffX = x[i] - x[j];
                diffY = y[i] - y[j];
                if (diffX < 0) {
                    diffX = diffX * (-1);
                }
                if (diffY < 0) {
                    diffY = diffY * (-1);
                }
                if (diffMax < diffX + diffY) {
                    diffMax = diffX + diffY;
                    point1 = i;
                    point2 = j;
                }
            }
        }
        double side = 0.0;
        if ((x[point1] - x[point2] == 0) || (y[point1] - y[point2] == 0)) {
            diagonal2 = Math.abs(x[point1] - x[point2]) + Math.abs(y[point1] - y[point2]);
            side = Math.sqrt(diagonal2);
        } else {
            if (Math.abs(x[point1] - x[point2]) > Math.abs(y[point1] - y[point2])) {
                side = Math.abs(x[point1] - x[point2]);
            } else {
                side = Math.abs(y[point1] - y[point2]);
            }
        }

        out.printf("%.4f", side);
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
