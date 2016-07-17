package HackerEarth;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 19-3-16.
 * FAKE MARRIAGE(Uninvited Guests)
 * https://www.hackerearth.com/lucid-tech-sol-java-hiring-challenge/problems/36239c25ad254287a3d39ef52778eba9/
 */
public class FM {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int N = in.nextInt();
        int Q = in.nextInt();
        List<String> nameList = new ArrayList<String>(N);
        List<String> nameOrAgeList = new ArrayList<String>(N);
        for (int i = 0; i < N; i++) {
            nameList.add(in.next());
        }
        int count =0;
        for (int i = 0; i < Q; i++) {
            String string;
            string = in.next();
            if(string.charAt(0)<59 && string.charAt(0)>47){
                if(Integer.valueOf(string)<=20)
                    count++;
            }else {
                if(!nameList.contains(string))
                    count++;
            }
        }
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
