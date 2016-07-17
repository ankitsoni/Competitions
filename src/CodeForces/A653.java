package CodeForces;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by asoni on 19-3-16.
 */
public class A653 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        boolean flag= false;
        for (int i = 1; i < n-1; i++) {
            if(a[i-1]+1 == a[i] && a[i]+1==a[i+1]){
                out.println("YES");
                flag = true;
                break;
            }
        }
        if(!flag)
            out.println("NO");
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
