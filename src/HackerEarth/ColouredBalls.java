package HackerEarth;
import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 19-3-16.
 */
class ColouredBalls {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int[] a = new int[4];
        int max=0;
        for (int i = 0; i < 4; i++) {
            a[i] = in.nextInt();
            if(max<a[i])
                max=i;
        }
        if(a[max]+a[max] >= a[0]+a[1]+a[2]+a[3]+1)
            out.print(0);
        else if(a[max]+a[max] >= a[0]+a[1]+a[2]+a[3]+1)
            out.print(2*factorial(a[0]+a[1]+a[2]+a[3]-a[max]));
        out.close();
    }
    static long factorial(int n){
        long[] l = new long[20];
        l[0] = 1;
        l[1] = 1;
        l[2] = 2;
        l[3] = 6;
        l[4] = 24;
        l[5] = 120;
        l[6] = 720;
        l[7] = 5040;
        l[8] = 40320;
        l[9] = 362880;
        l[10] = 3628800;
        l[11] = 39916800;
        l[12] = 479001600;
        l[13] = 6227020800l;
        l[14] = 87178291200l;
        l[15] = 1307674368000l;
        l[16] = 20922789888000l;
        l[17] = 355687428096000l;
        l[18] = 6402373705728000l;
        l[19] = 121645100408832000l;
        return l[n];
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
