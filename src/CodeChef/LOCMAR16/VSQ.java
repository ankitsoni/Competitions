package CodeChef.LOCMAR16;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by asoni on 27-3-16.
 */
public class VSQ {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder();
/*        int n = in.nextInt();
        int[] arr = new int[n];
        int[] count = new int[1000000001];
        int count = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int t = in.nextInt();
        do {
            int a = in.nextInt();
            int b = in.nextInt();
            for (int i = 0; i < n; i++) {
                if (arr[i] == a && pos1 == -1)
                    pos1 = i;
                if (arr[n - i - 1] == b && pos2 == -1)
                    pos2 = n - i - 1;
                if (pos1 != -1 && pos2 != -1) {
                    sb.append(pos2 - pos1 +1 +"\n");
                    break;
                }
            }
            if (pos1 == -1 && pos2 == -1)
                sb.append(0);
        } while (--t > 0);*/
        out.println(sb);
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