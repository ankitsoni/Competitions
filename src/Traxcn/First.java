package Traxcn;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by asoni on 1/24/2017.
 */
public class First {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String a = in.next();
        out.println(bomber(a));
        out.close();
    }

    public static String bomber(String s) {
        char[] ar = s.toCharArray();

        if (ar.length < 3)
            return String.valueOf(ar);

        int[] stack = new int[ar.length];
        char[] stackAr = new char[ar.length];
        stack[0] = 1;
        stackAr[0] = ar[0];
        int si = 0;

        for (int i = 1; i < ar.length; i++) {
            if (ar[i] == stackAr[si])
                stack[si]++;
            else {
                si++;
                stack[si] = 1;
                stackAr[si] = ar[i];
            }

            while (si > 0 && stack[si] >= 3)
                si--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= si; i++) {
            if (stack[i] >= 3)
                continue;

            for (int j = 0; j < stack[i]; j++)
                sb.append(stackAr[i]);
        }

        return sb.toString();
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
