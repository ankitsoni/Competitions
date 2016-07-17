package CodeChef.LOCMAR16;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 26-3-16.
 */
public class CHEFREC {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            int N = in.nextInt();
            int M = in.nextInt();
            int[][] matrix = new int[N][M];
            List<List<Integer>> integerList = new ArrayList<List<Integer>>((N - 1) + (M - 1));
            for (int i = 0; i <= (N - 1) + (M - 1); i++) {
                List list = new ArrayList();
                integerList.add(i, list);
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    matrix[i][j] = in.nextInt();
                    List list = integerList.get(i + j);
                    list.add(matrix[i][j]);
                }
            }
            for (int i = 0; i < integerList.size(); i++) {
                ListIterator<Integer> itr = integerList.get(i).listIterator();
                while (itr.hasNext())
                    out.print(itr.next() + " ");
            }
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
