package CodeChef.DEC16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 12/6/2016.
 */
public class ANKTRAIN {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            int n = in.nextInt();
            out.println(solve(n));
        } while (--t > 0);
        out.close();
    }

    static String solve(int n){
        int p = n%8;
        int q = n/8;
        StringBuilder seat = new StringBuilder();
        if(p==0) {
            seat.append(n-1);seat.append("SL");
        }else if(p<4){
            seat.append(n+3);
            if(p==1) seat.append("LB");
            else if(p==2) seat.append("MB");
            else if(p==3) seat.append("UB");
        }else if(p<7){
            seat.append(n-3);
            if(p==4) seat.append("LB");
            else if(p==5) seat.append("MB");
            else if(p==6) seat.append("UB");
        }else if(p==7) {
            seat.append(n+1);seat.append("SU");
        }
        return seat.toString();
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
