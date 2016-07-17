package CodeChef.MARCH16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 5-3-16.
 */
public class STRPALIN {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        String[] strings = new String[2];
        do {
            int[] str1CharArray = new int[26];
            int[] str2CharArray = new int[26];
                strings[0] = in.next();
                strings[1] = in.next();
            for (int i = 0; i < strings[0].length(); i++) {
                str1CharArray[strings[0].charAt(i)-97]=1;
            }
            for (int i = 0; i < strings[1].length(); i++) {
                str2CharArray[strings[1].charAt(i)-97]=1;
            }
            for (int i = 0; i < 26; i++) {
                if(str1CharArray[i]==1 && str2CharArray[i]==1){
                    out.println("Yes");
                    break;
                }
                if(i==25){
                    out.println("No");
                }
            }
        } while (--t > 0);

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
