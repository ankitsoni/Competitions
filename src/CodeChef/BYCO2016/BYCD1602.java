package CodeChef.BYCO2016;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 26-2-16.
 */
public class BYCD1602 {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t > 0) {
            t--;
            int N = in.nextInt();
            long[] A = new long[N];
            long total =0;
            for(int i=0;i<N;i++){
                A[i] = in.nextLong();
                if(i>0 && A[i-1]<A[i]){
                    total = total+(A[i]-A[i-1]);
                    A[i]=A[i-1];
                }
            }
            out.println(total);
        }
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

    }
}
