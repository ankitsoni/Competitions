package HackerRank;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 17-7-16.
 */
public class BearandSteadyGene {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        String s = in.next();
        out.println(solve(s));
        out.close();
    }

    static int solve(String s){
        int ac=0,cc=0,gc=0,tc=0,normal=0;
        normal = (s.length()+1)/4;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'A')
                ac++;
            else if(c == 'C')
                cc++;
            else if(c == 'G')
                gc++;
            else if(c == 'T')
                tc++;
        }
        
        return 0;
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
