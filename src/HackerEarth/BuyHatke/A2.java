package HackerEarth.BuyHatke;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 2/5/2017.
 */
public class A2 {
    public static void main(String[] args) {
        try {
            InputReader in = new InputReader(System.in);
            PrintWriter out = new PrintWriter(System.out);
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            HashMap<Integer, Set<Integer>> spCities = new HashMap<Integer, Set<Integer>>();
            int[] dir = new int[x];
            for (int i = 0; i < m; i++) {
                int k = in.nextInt();
            }


            for (int i = 0; i < x; i++) {
                int p = in.nextInt();
                int q = in.nextInt();
            }
            int power = 0;
            for (Map.Entry<Integer, Set<Integer>> entry : spCities.entrySet()) {
                Set t1 = entry.getValue();
                power = power + t1.size() - 1;

            }
            power += n - m;
            out.println(power);
            out.close();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
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

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}
