package CodeChef.APRIL16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 3-4-16.
 */
public class CHBLLNS {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do{
            long r = in.nextLong();
            long g = in.nextLong();
            long b = in.nextLong();
            long k = in.nextLong();
            long count = 0l;
            if (k>r)
                count += r;
            else
                count += k-1;
            if (k>g)
                count += g;
            else
                count += k-1;
            if (k>b)
                count += b;
            else
                count += k-1;
            out.println(count+1);
        }while (--t>0);
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



