package HackerEarth.Treebo;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 3/24/2017.
 */
public class A1 {
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int t = in.nextInt();
        do {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i+1;
            }
            boolean ans = findPartition(arr, n);
            if (ans ) out.println("Yes");
            else out.println("No");
        } while (--t > 0);
        out.close();
    }

    static boolean findPartition(int arr[], int n) {
        int sum = 0;
        int i, j;

        for (i = 0; i < n; i++)
            sum += arr[i];

        if (sum % 2 != 0)
            return false;

        boolean part[][] = new boolean[sum / 2 + 1][n + 1];

        for (i = 0; i <= n; i++)
            part[0][i] = true;

        for (i = 1; i <= sum / 2; i++)
            part[i][0] = false;

        for (i = 1; i <= sum / 2; i++) {
            for (j = 1; j <= n; j++) {
                part[i][j] = part[i][j - 1];
                if (i >= arr[j - 1])
                    part[i][j] = part[i][j] ||
                            part[i - arr[j - 1]][j - 1];
            }
        }
        return part[sum / 2][n];
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