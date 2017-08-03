package HackerEarth.Treebo;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 3/24/2017.
 */
public class A2 {

    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int m = in.nextInt();
        int[] dest = new int[m+1];
        for (int i = 1; i <= m; i++) {
            dest[i] = in.nextInt();
        }
        int q  = in.nextInt();
        int[] type = new int[q];
        int[] node = new int[q];
        for (int i = 0; i < q; i++) {
            type[i] = in.nextInt();
            node[i] = in.nextInt();
        }
        solve(dest,type,node);
        out.close();
    }

    static void solve(int[] dest,int[] type,int[] node){

        for (int i = 0; i < type.length; i++) {
            if(type[i] == 1){
                boolean printed = false;
                int start = node[i];
                int last = start;
                for (int j = 1; j <= dest.length; j++) {
                    if(dest[last] != 0)
                        last = dest[last];
                    else{
                        out.println(last);
                        printed = true;
                        break;
                    }
                    if(last == start)
                        break;
                }
                if(!printed)
                    out.println("LOOP");
            }else if(type[i] ==2){
                int key = node[i];
                dest[key] = 0;
            }
        }
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

        public String line() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
