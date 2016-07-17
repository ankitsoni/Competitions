package Google.CodeJam8April2016.Round1C;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 8-5-16.
 */
public class SenateEvacuation {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        int counter = 1;
        do {
            int n = in.nextInt();
            int[] a = new  int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int count =0,total  = 0;
            do{

            }while (count !=n);
            out.println("Case #"+(counter++)+": "+n);
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
