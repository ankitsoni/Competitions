package Neustar_CodeDangal;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 3/6/2017.
 */
public class A2 {
//    public static void main(String[] args) {
//        InputReader in = new InputReader(System.in);
//        PrintWriter out = new PrintWriter(System.out);
//        int t = in.nextInt();
//        do {
//            int a = in.nextInt();
//            int b = in.nextInt();
//            int c = in.nextInt();
//            int d = in.nextInt();
//            int e = in.nextInt();
//            int f = in.nextInt();
//            out.println(solve(a,b,c,d,e,f));
//        } while (--t > 0);
//        out.close();
//    }
//
//    static String solve(int a,int b,int c,int d,int e,int f){
//        if((a*e - b*d)==0)
//            return "no answer";
//        int y = (a*f-d*c)/(a*e- b*d);
//        int x =
//    }

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
