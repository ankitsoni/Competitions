package CodeChef.SEPT16;

//import Library.Generator;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by asoni on 9/7/2016.
 */
public class LEXOPAL {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            out.println(solve(in.next()));
        } while (--t > 0);
        out.close();
    }

    private static String solve(String str) {
        StringBuilder returnStr = new StringBuilder();
        int strlen = str.length();
        for (int i = 0; i < strlen / 2; i++) {
            if (str.charAt(i) != '.') {
                returnStr.append(str.charAt(i));
            } else if (str.charAt(strlen - i - 1) != '.') {
                returnStr.append(str.charAt(strlen - i - 1));
            } else
                returnStr.append('a');
            if (returnStr.charAt(i) != str.charAt(strlen - i - 1) && str.charAt(strlen - i - 1) != '.') {
                return "-1";
            }
        }

        int start = strlen / 2;
        if (strlen % 2 == 1) {
            start = strlen / 2 + 1;
            if (str.charAt(strlen / 2) != '.') {
                returnStr.append(str.charAt(strlen / 2));
            } else {
                returnStr.append('a');
            }
        }

        for (int i = start; i < strlen; i++) {
            if (str.charAt(i) != '.') {
                returnStr.append(str.charAt(i));
            } else {
                returnStr.append(returnStr.charAt(strlen - i -1));
            }
            if (returnStr.charAt(i) != returnStr.charAt(strlen - i - 1)) {
                return "-1";
            }
        }
        return returnStr.toString();
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
