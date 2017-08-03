import java.io.*;
import java.util.*;

/**
 * Created by asoni on 7/29/2017.
 */
public class Whatfix {
    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        printArr(arr, n);
        solve(arr, n);
        out.close();
    }

//    static solve1(int[][] arr,int n){
//        for (int i = 0; i < n; i++) {
//            int curr = a[i][i];
//            for (int j = 0; j < n; j++) {
//                arr[]
//            }
//        }
//    }

    // 4 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
    static void solve(int[][] arr, int n) {
        for (int k = 0; k < n; k++) {
            for (int i = k; i < n; i++) {
                int temp = arr[i][k];
                arr[i][k] = arr[k][i];
                arr[k][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][n-1-j];
                arr[i][n-1-j] = temp;
            }
        }
        printArr(arr, n);
    }

    static void printArr(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(arr[i][j]+" ");
            }
            out.println();
        }
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
