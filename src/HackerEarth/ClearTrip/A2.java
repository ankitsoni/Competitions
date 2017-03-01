package HackerEarth.ClearTrip;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by asoni on 2/11/2017.
 */
public class A2 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        int t = in.nextInt();
//        do {
//            int n = in.nextInt();
//            for (int i = 0; i < n; i++) {
//                rock rock = new rock();
//                rock.x = in.nextInt();
//                rock.y = in.nextInt();
//                rock.r = in.nextInt();
//            }
//            long a = in.nextInt();
//            long b = in.nextInt();
//            out.println(solve(a,b,y,y,z));
//        } while (--t > 0);
        out.close();
    }

    static long solve(int a, int b, int[] x, int[] y,int[] r) {
        long count = 0;
//        int[] num = getArrayCount(N);
//        for (int i = 1; i <= 999; i++) {
//            for (int j = i + 1; j <k; j++) {
//                if ((i + j) % k == x && (i * j) % k == y) {
//                    count += num[i] * num[j];
//                }
//            }
//        }
        return count;
    }

    class rock{
        long x;
        long y;
        long r;
        ArrayList<rock> rocks = new ArrayList<rock>();
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
