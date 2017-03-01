package CodeChef.SEPT16;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by asoni on 9/7/2016.
 */
public class LONGSEQ {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do{
            out.println(solve(new StringBuilder(in.next())));
        }while (--t > 0);
        out.close();
    }

    private static String solve(StringBuilder str){
        int count1 = 0;
        int count0 = 0;
        if(str.length() == 1){
            return "Yes";
        }
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0')
                count0++;
            else
                count1++;
            if(count1 > 1 && count0 > 1)
                return "No";
        }
        if(count0 == 1 || count1 == 1 ){
            return "Yes";
        }
        return "No";
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
