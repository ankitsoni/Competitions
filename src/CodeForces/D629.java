package CodeForces;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 20-2-16.
 */
public class D629 {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int[] r = new int[n];
        int[] h = new int[n];
        long r2h,r2hPrev=0,r2hSum=0;
        for(int i=0;i<n;i++){
            r[i] = in.nextInt();
            h[i] = in.nextInt();
            r2h= r[i]*r[i]*h[i];
            if(i==0 || r2h>r2hPrev){
                r2hPrev = r2h;
                r2hSum =r2hSum + r2h;
            }
        }
        double result = 0.0+(r2hSum*3.141592653589793);
        out.printf("%.9f",result);

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
