package HackerRank.Zapr;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by asoni on 2/25/2017.
 */
public class A3 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.next();
        }
        String[] b = new String[n];
        for (int i = 0; i < n; i++) {
            b[i] = in.next();
        }
        solve(a,b);
        out.close();
    }

    static int[]  solve(String[] a,String[] b) {
        int[] ans = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if(a[i].length()!= b[i].length()){
                ans[i] = -1;continue;
            }
            int[] charA = new int[26];
            int[] charB = new int[26];
            for (int j = 0; j < a[i].length(); j++) {
                charA[a[i].charAt(j) - 'a']++;
            }
            for (int j = 0; j < b[i].length(); j++) {
                charB[b[i].charAt(j) - 'a']++;
            }
            int change = 0;
            for (int j = 0; j < 26; j++) {
                change+=Math.abs(charA[j] - charB[j]);
            }
            ans[i] = change/2;
        }
        return ans;
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

