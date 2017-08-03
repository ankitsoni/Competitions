package Google.Apr2017.Quali;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by asoni on 4/8/2017.
 */
public class Tidy {
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int i =1;
        int t = in.nextInt();
        do{
            out.println("Case #"+i+": "+solve(in.next()));
            i++;
        }while (--t>0);
        out.close();
    }

    static String solve(String l) {
        char[] arr = l.toCharArray();
        if(arr.length ==1)
            return l.toString();
        char[] newStr = new char[arr.length];
        char k = '1';
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '0')
                k = '0';
            if(arr[i] != k)
                break;
            if(i == arr.length-1)
                return String.valueOf(newStr);
            newStr[i] = '9';
        }
        for (int i = 0 ; i < arr.length -1; i++) {
            if(arr[i] > arr[i + 1]){
                arr[i]--;
                arr[i+1]= '9';
                i--;
            }
        }
        return String.valueOf(arr);
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
