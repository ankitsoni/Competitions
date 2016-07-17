package HackerEarth.practice.algorithms.dynamic_programming;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 27-6-16.
 */
public class OnceUponAtimeInTimeLand {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        try{
            int t = in.nextInt();
            do {
                int n = in.nextInt();
                int k = in.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }
                long res = solve(arr,n,k);
                out.println(res);
            } while (--t > 0);
        }catch (Exception e){
            e.printStackTrace();
        }
        out.close();
    }

    static long solve(int[] arr,int n,int k){
        long[] sum = new long[n];
        if(arr[0]>=0)
            sum[0]= arr[0];
        for (int i = 1; i <= k; i++) {
            if(sum[i-1]<arr[i])
                sum[i] = arr[i];
            else
                sum[i] = sum[i-1];
        }
        for (int i = k+1; i < n; i++) {
            if(sum[i-k-1]+arr[i]<sum[i-1])
                sum[i] = sum[i-1];
            else
                sum[i] = sum[i-k-1]+arr[i];
        }
        return sum[n-1];
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
