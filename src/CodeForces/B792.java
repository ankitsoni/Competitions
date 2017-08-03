package CodeForces;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 3/27/2017.
 */
public class B792 {
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] p = new int[k];
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = 1;
        }
        for (int i = 0; i < k; i++) {
            p[i] = in.nextInt();
        }
        solve(n, k, p,x);
        out.close();
    }

    static void solve(int n, int k, int[] p, int[] x) {
        int currPos = 0;
        for (int i = 1; i <= k; i++,currPos++,n--) {
            int key = p[i];
            if (key == n) {
                out.print((currPos+1 )+ " ");
                x[currPos] = -1;
                continue;
            }
            else if (key > n) {
                key = (key+currPos) % n;

            }
            for (int j = 0; j < key; j++) {
                if(x[i] == -1){
                    j--;
                    currPos +=1;
                    continue;
                }
                currPos +=1;
            }
            x[currPos -1] = -1;
            out.print((currPos+1)+" ");
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


