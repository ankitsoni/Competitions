package HackerEarth;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 22-5-16.
 */
public class DaisyAndThePassword {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t =in.nextInt();
        do{
            String s = in.next();
            String p = in.next();
            int slen = s.length();
            int plen = p.length();
            int sIndex = p.indexOf(s);
            boolean flag = false;
                if (plen != 2 * slen) {
                    out.println("Impossible");
                    flag = false;
                } else if (sIndex!=-1) {
                    String newString;
                    if(sIndex==0) {
                        newString = p.substring(sIndex, slen);
                    }else {
                        String prev = p.substring(0, sIndex );
                        String after = p.substring(sIndex + slen , plen);
                        newString = prev.concat(after);
                    }
                    if (newString.equals(s)) {
                        out.println("Possible");
                    } else {
                        out.println("Impossible");
                    }
                }else{
                    out.println("Impossible");
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
