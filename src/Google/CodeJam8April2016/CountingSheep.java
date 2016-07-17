package Google.CodeJam8April2016;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 9-4-16.
 */
public class CountingSheep {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        int counter = 1;
        do {
            int n = in.nextInt();
            int[] a = new  int[10];
            a[0] = -5874;
            if(n == 0){
                out.println("Case #"+(counter++)+": INSOMNIA");
                continue;
            }
            for (int i = 0,temp = n,sum =0; true ; i++,temp=i*n) {
                sum =0;
                while(temp > 0){
                    a[temp%10] = temp %10;
                    temp = temp /10;
                }
                for (int j = 0; j < 10 ; j++) {
                    sum += a[j];
                }
                if(sum == 45){
                    n = i *n;
                    break;
                }

            }
            out.println("Case #"+(counter++)+": "+n);
        } while (--t > 0);
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





