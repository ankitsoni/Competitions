package HackerEarth;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by asoni on 29-5-16.
 */
public class AvoidBoredom {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            Arrays.sort(a);
            if(m==1){
                out.println(a[n-1]);
            }else{
                int sum =0;
                for (int i = 0,j=n-1; i < m &&j>0; ) {
                    sum = sum+a[n-i-1]-a[i];
                    if(i%2==0)
                        j--;
                    else
                        i++;
                }
            }
        }while (--t > 0);
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

    }
}

