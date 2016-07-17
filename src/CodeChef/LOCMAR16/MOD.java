package CodeChef.LOCMAR16;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by asoni on 26-3-16.
 */
public class MOD {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int[] a = new int[n];
        int max = 0;
        int secondMax = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            if (a[i] > max) {
                secondMax = max;
                max = a[i];
            } else if (a[i] > secondMax && a[i]!=max) {
                secondMax = a[i];
            }
        }
        if(n == 1){
            out.println(0);
            out.close();
            return;
        }
        int maxMod = 0, currentMod = 0;
        for (int i = 0; i < n; i++) {
            currentMod = max % a[i];
            if (currentMod > maxMod)
                maxMod = currentMod;
        }
        if (maxMod > secondMax)
            out.println(maxMod);
        else
            out.println(secondMax);
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

