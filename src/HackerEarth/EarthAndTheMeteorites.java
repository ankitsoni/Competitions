package HackerEarth;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by asoni on 25-3-16.
 */
public class EarthAndTheMeteorites {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            int N = in.nextInt();
            int M = in.nextInt();
            int Q = in.nextInt();
            int[] x = new int[Q];
            int[] y = new int[Q];
            int[][] earth = new int[N][M];
            int portion = 1;
            for (int i = 0; i < Q; i++) {
                x[i] = in.nextInt();
                y[i] = in.nextInt();
            }
            Arrays.sort(x);
            Arrays.sort(y);
            int minx = x[0]-1, maxx = x[0]-1;
            int miny = y[0]-1, maxy = y[0]-1;
            for (int i = 0; i < Q; i++) {
                if (i == Q - 1) {
                    maxx = maxx < M - x[i] ? M - x[i] : maxx;
                    maxy = maxy < N - y[i] ? N - y[i] : maxy;
                    minx = minx > M - x[i] ? M - x[i] : minx;
                    miny = miny > N - y[i] ? N - y[i] : miny;
                    continue;
                }
                maxx = maxx < x[i + 1] - x[i] ? x[i + 1] - x[i] : maxx;
                maxy = maxy < y[i + 1] - y[i] ? y[i + 1] - y[i] : maxy;
                minx = minx > x[i + 1] - x[i] ? x[i + 1] - x[i] : minx;
                miny = miny > y[i + 1] - y[i] ? y[i + 1] - y[i] : miny;
            }
            out.println(maxx*maxy);
            out.println(minx*miny);
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
