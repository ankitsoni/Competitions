import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 22-6-16.
 */
public class Amazon {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        char[][] dv = new char[n][n];
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            s.append(in.next());
            for (int j = 0; j < n; j++) {
                dv[i][j] = s.charAt(j);
            }
        }

        int[][] cost = new int[n][n];
        cost[n-1][n-1] = 0;
        for (int j = n-2; j >=0; j--) {
            cost[n-1][j] = cost[n-1][j+1] + 1;
        }
        for (int i = n-2; i >=0; i--) {
            cost[i][n-1] = cost[i+1][n-1] + 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if(dv[i][j]!='V'){
                    if (cost[i + 1][j] != 0 && cost[i][j + 1] != 0)
                        cost[i][j] = Math.min(cost[i + 1][j], cost[i][j + 1]) + 1;
                    else if (cost[i + 1][j] == 0 && cost[i][j + 1] != 0)
                        cost[i][j] = cost[i][j + 1] + 1;
                    else if (cost[i + 1][j] != 0 && cost[i][j + 1] == 0)
                        cost[i][j] = cost[i + 1][j] + 1;
                }

            }
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                out.print(cost[i][j]);
//            }
//            out.println();
//        }
        out.print(cost[0][0]);
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

