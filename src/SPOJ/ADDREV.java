package SPOJ;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 12-3-16.
 */
public class ADDREV {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder();
        int N = in.nextInt();
        do {
            String number1 = in.next();
            String number2 = in.next();
            int len1 = number1.length();
            int len2 = number2.length();
            int maxlen = len1 > len2 ? len1 : len2;
            int minlen = len1 < len2 ? len1 : len2;
            Integer a, b, carry=0,sum;
            for (int i = 0; i < maxlen; i++) {
                if (i > minlen) {
                    continue;
                }
                a = Integer.valueOf((int) number2.charAt(i));
                b = (int) number2.charAt(i);
                sum = a+b+carry;
                if(sum>9){
                    carry =(int)sum. toString().charAt(1);
                    sb.append((int)sum. toString().charAt(0));
                    continue;
                }
                sb.append(sum);
                carry=0;
            }
            out.print(sb);
        } while (--N > 0);

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

