package CodeForces;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 17-2-16.
 */
public class OlesyaAndRodion {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int t = in.nextInt();
        if(n==1){
            if(t!=10)
                out.print(t);
            else
                out.print(-1);
            out.close();
            return;
        }else if(t==10){
            out.print(t);
            while(n-1>1){
                out.print(0);
                n--;
            }
        }else {
            out.print(t);
            while(n>1){
                out.print(0);
                n--;
            }
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

    }
}
