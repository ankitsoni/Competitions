package HackerEarth.BlueOptima_InterviewCall;
import java.io.*;
import java.util.*;

public class Q2 {
    private static int[][][] excludeArray, includeArray;
    private static int[] sums;

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        try {
            int t = in.nextInt();
            do {
                int n = in.nextInt();
                int k = in.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i]= in.nextInt();
                }
                out.println(MinimizeSum.minSum(arr,n,k));
            } while (--t > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.close();
    }


    final static class MinimizeSum {
        private static int[][][] excludeArray, includeArray;
        private static int[] sums;

        private static void populate(int[] ar) {
            int n = ar.length;
            excludeArray = new int[n][n][];
            includeArray = new int[n][n][];

            for (int i = 0; i < n; i++)
                for (int j = i; j < n; j++) {
                    int width = j - i + 1;
                    excludeArray[i][j] = new int[n - width];
                    includeArray[i][j] = new int[width];

                    for (int k = 0; k < i; k++)
                        excludeArray[i][j][k] = ar[k];

                    for (int k = j + 1; k < n; k++)
                        excludeArray[i][j][k - width] = ar[k];

                    for (int k = i; k <= j; k++)
                        includeArray[i][j][k - i] = ar[k];

                    Arrays.sort(excludeArray[i][j]);
                    Arrays.sort(includeArray[i][j]);
                }

            sums = new int[ar.length];
            sums[0] = ar[0];

            for (int i = 1; i < ar.length; i++)
                sums[i] = ar[i] + sums[i - 1];
        }

        public static int minSum(int[] ar, int n, int k) {
            if (allNegative(ar))
                return sum(ar);

            int min = min(ar);
            if (min >= 0)
                return min;

            int pos = 0, neg = 0;
            for (int e : ar) {
                if (e == 0)
                    continue;

                if (e > 0)
                    pos++;
                else neg++;
            }

            if (k >= pos || k >= neg)
                return negativeSum(ar);

            return process(ar, k, negativeSum(ar));
        }

        private static int process(int[] ar, int k, int minLimit) {
            populate(ar);
            int minSum = ar[0];

            for (int i = 0; i < ar.length && minSum > minLimit; i++)
                for (int j = 0; j < ar.length; j++) {
                    int[] include = includeArray[i][j], exclude =
                            excludeArray[i][j];

                    if (include == null || exclude == null)
                        continue;

                    int sum = sums[j] - (i == 0 ? 0 : sums[i - 1]);

                    for (int x = include.length - 1, y = 0; x >= 0 && y <
                            exclude.length && y < k; x--, y++) {
                        if (include[x] <= exclude[y])
                            break;

                        sum += exclude[y] - include[x];
                    }

                    minSum = Math.min(minSum, sum);
                    if (minSum == minLimit)
                        return minLimit;
                }

            return minSum;
        }

        private static int negativeSum(int[] ar) {
            int sum = 0;

            for (int e : ar)
                if (e < 0)
                    sum += e;

            return sum;
        }

        private static int[] countNegatives(int[] ar) {
            int[] res = new int[ar.length];
            if (ar[0] <= 0)
                res[0] = 1;

            for (int i = 1; i < ar.length; i++)
                res[i] = ar[i] <= 0 ? res[i - 1] + 1 : res[i - 1];

            return res;
        }

        private static int min(int[] ar) {
            int min = Integer.MAX_VALUE;

            for (int e : ar)
                if (min > e) min = e;

            return min;
        }

        private static boolean allNegative(int[] ar) {
            for (int e : ar)
                if (e > 0)
                    return false;

            return true;
        }

        private static int sum(int[] ar) {
            int sum = 0;
            for (int e : ar)
                sum += e;

            return sum;
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




