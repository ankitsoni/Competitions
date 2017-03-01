package HackerEarth.Soroco;

import com.sun.org.apache.xalan.internal.lib.NodeInfo;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 2/19/2017.
 */
public class A1 {


    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            int n = in.nextInt();
            long[] num = new long[n];
            for (int i = 0; i < n; i++) {
                num[i] = in.nextInt();
            }
            out.println(solve(num));
        } while (--t > 0);
        out.close();
    }

    static long solve(long[] num) {
        long answer = 0;
        for (int i = 0; i < num.length; i++) {
            int just2Pow = 1;
            int currValue = ((int)num[i]*(int)pow(2,i));
//            if( currValue & (currValue-1) == 0)
//                just2Pow = currValue;
//            else{
//                while (currValue != 0 && currValue!=1) {
//                    currValue = currValue >> 1;
//                    just2Pow = just2Pow << 1;
//                }
//            }
            long index = pow(2,i)*just2Pow;
            int arrS = num.length;
            if (just2Pow > 1 && index < arrS) {
                num[(int)just2Pow*(int)pow(2,i)]++;
                answer += num[i] - just2Pow;
            }else{
                answer+=just2Pow;
            }
        }
        return answer;
    }

    static long pow(long a, long b) {
        if (b == 0) return 1;
        if (b == 1) return a;
        if (b % 2 == 0) return pow(a * a, b / 2);
        else return a * pow(a * a, b / 2);

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
