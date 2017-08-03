package HackerEarth.Amazon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 2/26/2017.
 */
public class A1 {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String a = in.next();
        out.println(solve(a));
        out.close();
    }

    static int solve(String string) {
        int startIndex = 0;
        int endIndex = string.length() - 1;
        while (string.charAt(startIndex) != 'a') {
            startIndex++;
        }
        while (string.charAt(endIndex) != 'c') {
            endIndex--;
        }
        String newS = null;
        if (startIndex < endIndex)
            newS = string.substring(startIndex, endIndex + 1);
        else
            return 0;
        int answer = 0;
        int aCount = 0, lastB = 0, cCount = 0;
        cCount++;
        for (int i = newS.length() - 2; i >= 0; i--) { // last is definate c
            switch (newS.charAt(i)) {
                case 'a':
                    answer = lastB * aCount + aCount + 1; // lastB + pattern with past + pattern with current
                    aCount = answer;
                    break;
                case 'b':
                    lastB = (cCount * (cCount + 1) / 2) + lastB;
                    break;
                case 'c':
                    cCount++;
                    break;
            }
        }
        return answer;
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
