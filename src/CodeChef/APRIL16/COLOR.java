package CodeChef.APRIL16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 3-4-16.
 */
public class COLOR {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do{
            int rooms = in.nextInt();
            String colors = in.next();
            int countR =0,countG=0,countB=0;
            for (int i = 0; i < rooms ; i++) {
                char c = colors.charAt(i);
                if (c =='R')
                    countR++;
                else if(c == 'G')
                    countG++;
                else if(c=='B')
                    countB++;
            }
            if(countR==rooms || countG == rooms || countB==rooms){
                out.println(0);
                continue;
            }
            if(countR>countG){
                if(countR>countB)
                    out.println(countB+countG);
                else
                    out.println(countR+countG);
            }
            else{
                if(countG>countB)
                    out.println(countB+countR);
                else
                    out.println(countR+countG);
            }
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


