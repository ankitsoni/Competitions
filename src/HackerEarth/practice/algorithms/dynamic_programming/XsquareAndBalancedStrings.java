package HackerEarth.practice.algorithms.dynamic_programming;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 28-6-16.
 */
public class XsquareAndBalancedStrings {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        try{
            int t = in.nextInt();
            do {
                String str = in.next();
                int[] arr = new int[26];
                for (int i = 0; i < str.length(); i++) {
                    arr[str.charAt(i) - 'a']++;
                }
                int res = solve(arr);
                out.println(res);
            } while (--t > 0);
        }catch (Exception e){
            e.printStackTrace();
        }
        out.close();
    }

    static int solve(int[] arr){
        int gcd =1;
        for (int i = 0; i <= 26; i++) {
            gcd = getGcd(arr[i],gcd);
        }
        return gcd;
    }

    static int getGcd(int a,int b){
        return 0;
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

