package CodeChef.FEB20;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SUNG_FIT {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCases = in.nextInt();
        do {
            int numSequences = in.nextInt();
            int[] A = new int[numSequences];
            int[] B = new int[numSequences];

            for (int i = 0; i < numSequences; i++) {
                A[i] = in.nextInt();
            }
            for (int i = 0; i < numSequences; i++) {
                B[i] = in.nextInt();
            }
            long result = 0;

            Arrays.parallelSort(A);
            Arrays.parallelSort(B);
            for (int i = 0; i < numSequences; i++) {
                result += Math.min(A[i],B[i]);
            }
            out.println(result);
        } while (--testCases > 0);
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

        public String line() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
