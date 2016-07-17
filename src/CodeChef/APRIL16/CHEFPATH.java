package CodeChef.APRIL16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 3-4-16.
 */
public class CHEFPATH {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            long n = in.nextLong();
            long m = in.nextLong();
            if(n*m%2!=0){
                out.println("No");
                continue;
            }
            if((n==1 && (m==1 || m>2)) || (m==1 && (n==1 || n>2))){
                out.println("No");
            }else
                out.println("Yes");
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