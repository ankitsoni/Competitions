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
        int[] a = new int[endIndex - startIndex + 1];
        int[] b = new int[endIndex - startIndex + 1];
        int[] c = new int[endIndex - startIndex + 1];
        c[newS.length() - 1]++;
        for (int i = newS.length() - 2; i >= 0; i--) { // last is definate c
            switch (newS.charAt(i)) {
                case 'a':
                    a[i] = a[i + 1] + 1;
                    b[i] = b[i + 1];
                    c[i] = c[i + 1];
                    break;
                case 'b':
                    a[i] = a[i + 1];
                    b[i] = b[i + 1] + 1;
                    c[i] = c[i + 1];
                    break;
                case 'c':
                    a[i] = a[i + 1];
                    b[i] = b[i + 1];
                    c[i] = c[i + 1] + 1;
                    break;
            }
        }
        int lastA = 0;
        int answer = 0;
        int lastCount = 0;
        int count = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] != lastA) {
                count = a[i] * b[i] * c[i];
                lastA = a[i];
                answer = count - lastCount;
                lastCount = answer;
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
