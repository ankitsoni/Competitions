package HackerEarth.ClearTrip;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 2/11/2017.
 */
public class A1 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        //int t = in.nextInt();
        //do {
        int n = in.nextInt();
        int k = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int[] N = new int[n];
        for (int i = 0; i < n; i++) {
            N[i] = in.nextInt();
        }
        out.println(solve(N,k,x,y));
        //} while (--t > 0);
        out.close();
    }

    static long solve(int[] N,int k,int x,int y) {
        long count =0;
        int[] num = getArrayCount(N);
        for (int i = 1; i <= 999; i++) {
            for (int j = i+1; j < k; j++) {
                if( (i+j)%k == x && (i*j)%k==y){
                    count += num[i]*num[j];
                }
            }
        }
        return count;
    }

    static int[] getArrayCount(int[] N){
        int[] arr = new int[1001];
        for (int i = 0; i < N.length; i++) {
            arr[N[i]]++;
        }
        return arr;
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
