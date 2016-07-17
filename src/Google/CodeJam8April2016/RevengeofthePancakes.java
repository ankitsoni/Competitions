package Google.CodeJam8April2016;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 9-4-16.
 */
public class RevengeofthePancakes {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        int counter = 1;
        do {
            String s = in.next();
            int changes = 0;
            char c = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                char curChar = s.charAt(i);
                if(curChar != c){
                    changes++;
                    c = curChar;
                }
            }
            if(s.charAt(s.length()-1) == '-')
                changes++;
            out.println("Case #" + (counter++) + ": " + changes);
        } while (--t > 0);
        out.close();
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






