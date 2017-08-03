package HackerEarth.Aristocrat;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 7/22/2017.
 */
public class P {
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int t = in.nextInt();
        do {
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            solve(n, a, b, c);
        } while (--t > 0);
        out.close();
    }

    static void solve(int n, int a, int b, int c) {
        int total = n/a + n/b + n/c;
        int gcdab = gcd(a,b);
        int gcdbc = gcd(b,c);
        int gcdca = gcd(c,a);
        int ab_ = (n/((a/gcdab)*(b/gcdab)))/gcdab;
        int bc_ = (n/((b/gcdbc)*(c/gcdbc)))/gcdbc;
        int ca_ = (n/((c/gcdca)*(a/gcdca)))/gcdca;
        int abc = a*b*c/(gcdab*gcdbc*gcdca);
        int abcPlus = (n/abc);
        if(gcdab== gcdbc && gcdbc==gcdca)
            abcPlus=abcPlus/3;
        else if((gcdab!=1 && gcdab== gcdbc) || (gcdbc==gcdca && gcdca!=1) || gcdca==gcdab)
            abcPlus = abcPlus/2;
        int answer = total - ab_ - bc_ - ca_ + abcPlus;
        out.println(answer);
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
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
