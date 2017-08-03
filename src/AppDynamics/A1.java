package AppDynamics;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 6/24/2017.
 */
public class A1 {
    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int[] primes;
    static int[] largestFactor;

    public static void main(String[] args) {
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        solve(arr);
        out.close();
    }

    private static int solve(int[] k) {
        int count = 0;
        for (int i = 0; i < k.length; i++) {
            count+= getDivisorsCount(k[i]);
        }
        return count;
    }

    static long getDivisorsCount(int n) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i=1; i<=Math.sqrt(n); i++)
        {
            if (n%i==0)
            {
                if (n/i == i) // check if divisors are equal
                    list.add(i);
                else
                {
                    list.add(i);
                    list.add(n/i);
                }
            }
        }
        long count=0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)%2!=0)
                count+=list.get(i);
        }
        return count;
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
