package Codelity.ReportGarden;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by asoni on 3/29/2017.
 */
public class A2 {
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        out.println(solve(in.next()));
        out.close();
    }

    static int solve(String s) {
        int[] opening = new int[s.length()];
        int[] closing = new int[s.length()];
        if (s.charAt(0) == '(')
            opening[0] = 1;
        else
            closing[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            opening[i] = opening[i - 1];
            closing[i] = closing[i - 1];
            if (s.charAt(i) == '(')
                opening[i]++;
            else
                closing[i]++;
        }
        if(opening[s.length()-1] ==0 || closing[s.length()-1]==0)
            return s.length();
        for (int i = 0; i < s.length(); i++) {
            if(opening[i] == (closing[s.length()-1] - closing[i]))
                return i+1;
        }
        return -1;
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
