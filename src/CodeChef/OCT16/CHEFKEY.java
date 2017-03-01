package CodeChef.OCT16;

import Library.Generator;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 10/14/2016.
 */
public class CHEFKEY {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            int n = in.nextInt();
            int m = in.nextInt();
            int c = in.nextInt();
            out.println(solve(n,m,c));
        } while (--t > 0);
        out.close();
    }

    static int solve(int n, int m , int c){
        List factors = getFactor(c);
        List<Pair> pairs = makePairs(factors);
        int badPairs = 0;
        for (Pair pair: pairs) {
            if(pair.b > m || pair.a > n || (pair.a*pair.b)>c)
                badPairs++;
        }
        return pairs.size()-badPairs;
    }

    static List getFactor(int c) {
        List<Integer> factors = new ArrayList();
        for (int i = 1; i <= c / 2; i++) {
            if (c % i == 0) {
                factors.add(i);
            }
        }
        factors.add(c);
        return factors;
    }

    static List makePairs(List<Integer> factors){
        List<Pair> pairs = new ArrayList<Pair>();
        for (int i = 0; i < factors.size() / 2; i++) {
            Pair pair1 = new Pair();
            pair1.a = factors.get(i);
            pair1.b = factors.get(factors.size()-i -1);
            pairs.add(pair1);
            Pair pair2 = new Pair();
            pair2.b = factors.get(i);
            pair2.a = factors.get(factors.size()-i -1);
            pairs.add(pair2);
        }
        return pairs;
    }

    static class Pair {
        int a;
        int b;
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
