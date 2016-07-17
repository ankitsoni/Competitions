package HackerEarth.practice.algorithms.dynamic_programming;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 23-6-16.
 */
public class Tutorial {
    public static long[] factMem = new long[100001];
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        try{
            int t = in.nextInt();
            do {
                int n = in.nextInt();
                if(factMem[n]==0){
                    out.println(getFact(n));
                }else{
                    out.println(factMem[n]);
                }
            } while (--t > 0);
        }catch (Exception e){
            e.printStackTrace();
        }
        out.close();
    }

    static long getFact(int n){
        if(n==0 || n==1)
            return 1;
        long fact;
        if(factMem[n]==0){
            fact = n*getFact(n-1);
            if(fact>1000000007){
                fact = fact % 1000000007;
            }
            factMem[n] = fact;
        }else{
            fact = factMem[n];
        }
        return fact;
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


