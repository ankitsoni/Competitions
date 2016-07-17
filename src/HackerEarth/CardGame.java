package HackerEarth;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 28-2-16.
 * url :https://www.hackerearth.com/accolite-java-hiring-challenge/problems/caa94d75032749e2be99cbd9221c6df0/
 */
public class CardGame {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            t--;
            int N = in.nextInt();
            int[] S = new int[N];
            int[] P = new int[N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                S[i] = in.nextInt();
            }
            for (int i = 0; i < N; i++) {
                P[i] = in.nextInt();
            }
            String name = in.next();
            for (int i = 0; i < N; i++) {
                if (S[i] == P[i])
                    count++;
            }
            int changes = N-count;
            if(N<=2){
                out.println("Devu");
                continue;
            }
            if(changes==1 && name.equals("Churu")){
                out.println("Devu");
                continue;
            }
            if(changes<=2 && name.equals("Devu"))
                out.println("Devu");
            else
                out.println("Churu");
        } while (t > 0);
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

