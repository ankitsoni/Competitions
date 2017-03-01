package CodeChef.LOCJUL16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 8/2/2016.
 */
public class LEVENSUB {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            out.println(solve(a, n));
        } while (--t > 0);
        out.close();
    }

    private static int solve(int[] a, int n) {
        int length = Integer.MIN_VALUE, start = Integer.MIN_VALUE, last = Integer.MIN_VALUE;
        int lastLengthSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) {
                if(last == i-1){
                    lastLengthSum+=a[i];
                    last=i;
                }else if(last == i-2){
                    if((lastLengthSum+a[i]+a[i-1])%2==0){
                        lastLengthSum+=a[i]+a[i-1];
                        last=i;
                    }
                }else{
                    start=i;
                    last=i;
                    lastLengthSum=a[i];
                }

                length = last - start + 1 > length ? last - start + 1 : length;
            }
        }
        length = last - start + 1 > length ? last - start + 1 : length;
        return length;
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
