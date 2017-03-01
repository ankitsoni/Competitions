package CodeChef.DEC16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 12/6/2016.
 */
public class KIRLAB {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            int n = in.nextInt();
            int[] roomMonsters = new int[n];
            for (int i = 0; i < n; i++) {
                roomMonsters[i] = in.nextInt();
            }
            out.println(solve(n, roomMonsters));
        } while (--t > 0);
        out.close();
    }

    static int solve(int n, int[] roomMonsters) {
        int maxCount=0;
        for (int k = 0; k < n; k++) {
            int count = 0;
            int last = 1;
            for (int i = k; i < n;) {
                if(roomMonsters[i]==1) {
                    i++;break;
                }
                for (int j = i + 1; j < n; j++) {
                    if (gcd(roomMonsters[i], roomMonsters[j]) > 1) {
                        count++;
                        i = j;
                        break;
                    }
                    if(j==n-1) i=n;
                }
            }
            maxCount = count>maxCount?(count > 0 ? count + 1 : count):maxCount;
        }
        return maxCount;
    }

    static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        return (b == 0) ? a : gcd(b, a % b);
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
