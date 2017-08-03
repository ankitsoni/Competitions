package HackerEarth.Jiva;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 7/26/2017.
 */
public class X {
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            int t = Integer.parseInt(in.nextLine());
            do {
                String s1 = in.nextLine();
                String s2 = in.nextLine();
                char c = in.nextLine().charAt(0);
                int i = Integer.parseInt(in.nextLine());
                solve(s1, s2, c, i);
            } while (--t > 0);
            out.close();
        }catch (Exception e){
            out.println(e.getMessage());
        }
    }

    static void solve(String s1, String s2, char c, int i) {
        int index = s1.indexOf(s2,i);
        if (index == -1) {
            out.println("Goodbye Watson.");
            return;
        }
        if (c == 'N') {
            out.println(index);
            return;
        } else {
            String[] s1s = s1.substring(i,s1.length()).split(" ");
            for(int j =0;j<s1s.length;j++){
                if(s1s[j].equals(s2)){
                    out.println(index);
                    return;
                }
            }
        }
        out.println("Goodbye Watson.");
    }

//    static class InputReader {
//        public BufferedReader reader;
//        public StringTokenizer tokenizer;
//
//        public InputReader(InputStream stream) {
//            reader = new BufferedReader(new InputStreamReader(stream), 32768);
//            tokenizer = null;
//        }
//
//        public String next() {
//            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
//                try {
//                    tokenizer = new StringTokenizer(reader.readLine());
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            return tokenizer.nextToken();
//        }
//
//        public String line() {
//            try {
//                return reader.readLine();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        public int nextInt() {
//            return Integer.parseInt(next());
//        }
//
//        public double nextDouble() {
//            return Double.parseDouble(next());
//        }
//
//        public long nextLong() {
//            return Long.parseLong(next());
//        }
//    }
}
