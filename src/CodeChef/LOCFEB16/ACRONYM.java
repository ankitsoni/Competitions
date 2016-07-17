package CodeChef.LOCFEB16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 27-2-16.
 */
public class ACRONYM {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String string = new String();
        int count = 0;
        do {
            string = in.next();
            if (string.length() > 1 && string.toUpperCase() == string) {
                count++;
            }
        }while (in.hasMoreToken());
        out.print(count);
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

        public boolean hasMoreToken(){
            if(tokenizer == null || !tokenizer.hasMoreTokens()) {
                return false;
            }
            return true;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}
