package CodeChef.MARCH17;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 3/4/2017.
 */
public class EXTRAN {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            solve(arr);
            out.println(solve(arr));
        } while (--t > 0);
        out.close();
    }

    static long solve(int[] arr) {
        int max = Integer.MIN_VALUE, sMax = Integer.MIN_VALUE, min = Integer.MAX_VALUE, sMin = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                sMax = max;
                max = arr[i];
            } else if (arr[i] > sMax)
                sMax = arr[i];
            if (arr[i] < min) {
                sMin = min;
                min = arr[i];
            } else if (arr[i] < sMin)
                sMin = arr[i];
        }
        if (max == sMax)
            return max;
        if (min == sMin)
            return min;
        if (max != sMax + 1)
            return max;
        if (min != sMin - 1)
            return min;


        int sum = 0;
        int preDiff = 0;
        if (min % 2 == 0 && max % 2 != 0) {
            sum = min + sMax;
            preDiff = max;
        } else if (max % 2 == 0 && min % 2 != 0) {
            sum = max + sMin;
            preDiff = min;
        }else{
            sum = max+min;
        }
        int avg = sum / 2;
        long diff = 0;
        diff = preDiff != 0 ? preDiff - avg : 0;
        for (int i = 0; i < arr.length; i++) {
            diff += avg - arr[i];
        }
        return avg - diff;
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

//4
//        12
//        7 8 9 10 11 12 13 14 15 16 17 15
//        11
//        7 8 9 10 11 12 13 14 15 16 15
//        11
//        8 9 10 11 12 13 14 15 16 17 15
//        12
//        8 9 10 11 12 13 14 15 16 17 18 15
