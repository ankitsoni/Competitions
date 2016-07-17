package CodeChef.COOK67;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 21-2-16.
 */
public class PPSUM {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t>0){
            t--;
            int d = in.nextInt();
            int n = in.nextInt();
            PPSUM ppsum = new PPSUM();
            int result = ppsum.solve(d,n);
            out.println(result);
        }
        out.close();
    }

    int solve(int d,int n){
        if(d==1){
            return (n*(n+1))/2;
        }
        return solve(d-1,(n*(n+1))/2);
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
