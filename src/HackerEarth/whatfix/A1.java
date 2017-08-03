package HackerEarth.whatfix;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 7/21/2017.
 */
public class A1 {
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int t = in.nextInt();
        do {
            String str = in.next();
            int k = in.nextInt();
            solve(str,k);
        } while (--t > 0);
        out.close();
    }

    static void solve(String str ,int k){
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }

        int[] sortedCount = Arrays.copyOf(count,count.length);
        Arrays.sort(sortedCount);
        int pos = 1;
        int height = Integer.MIN_VALUE;
        for (int i = 24; i >=0 ; i--) {
            if(sortedCount[i+1]!=sortedCount[i]){
                pos++;
            }
            if(pos == k)
            {
                height = sortedCount[i];
                break;
            }
        }
        if(pos == k && height>0){
            for (int i = 0; i < 26; i++) {
                if(height == count[i]){
                    char c = (char)(97+i);
                    out.println(c);
                    return;
                }
            }
        }
        out.println("-1");
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
