package Brisky;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by asoni on 1/19/2017.
 */
public class A1 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int numsize = in.nextInt();
        int[] nums = new int[numsize];
        for (int i = 0; i < numsize; i++) {
            nums[i] = in.nextInt();
        }
        int maxesSize = in.nextInt();
        int[] maxes = new int[maxesSize];
        for (int i = 0; i < maxesSize; i++) {
            maxes[i] = in.nextInt();
        }
        int[] answer = counts(nums, maxes);
        for (int i = 0; i < answer.length; i++) {
            out.println(answer[i]);
        }
        out.close();
    }

    static int[] counts(int[] nums, int[] maxes) {
        int[] answer = new int[maxes.length];
        Arrays.sort(nums);
        for (int i = 0; i < maxes.length; i++) {
            answer[i] = binarySearch(nums, 0, nums.length - 1, maxes[i]);
        }
        return answer;
    }

    static int binarySearch(int arr[], int l, int r, int x) {
        int m = 0;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m] <= x){
                if( m+1 !=arr.length && arr[m + 1] > x)
                return m + 1;
            }
            if (arr[m] < x)
                l = m + 1;
            if (arr[m] > x)
                r = m - 1;
        }
        if(m!=0) return m + 1;
        return m;
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

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}
