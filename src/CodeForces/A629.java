package CodeForces;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 20-2-16.
 */
public class A629 {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int i, j, sumi, sumj;
        char[][] arr = new char[n][];
        int[] countI = new int[n];
        int[] countJ = new int[n];
        for (i = 0, countI[i] = 0; i < n; i++) {
            for (j = 0, countJ[j] = 0; i < n; j++) {
                arr[i][j] = in.next().charAt(0);
                if (arr[i][j] == 'c') {
                    countJ[j]++;
                    countI[i]++;
                }
            }
        }
        for (i = 0, sumi = 0, sumj = 0; i < n; i++) {
            sumi = sumi + ((countI[i] * (countI[i] + 1)) / 2);
            sumj = sumj + ((countJ[i] * (countJ[i] + 1)) / 2);
        }
        out.print(sumi+sumj);
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
