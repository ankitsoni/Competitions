package HackerEarth;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 13-3-16.
 */
public class TanyaAndLassi {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            int L = in.nextInt();
            int[] money = new int[L];
            double[] perUnitMoney = new double[L];
            for (int i = 0; i < L; i++) {
                money[i] = in.nextInt();
                perUnitMoney[i] = 1.0*money[i]/(i+1);
            }
            double maxPerUnit;
            int l=L,sum=0,maxPerUnitIndex;
            for (int i = 0; i < L; i++) {
                maxPerUnitIndex=0;
                maxPerUnit=0.0;
                for (int j = 0; j < l; j++) {
                    if(maxPerUnit<perUnitMoney[j]){
                        maxPerUnit=perUnitMoney[j];
                        maxPerUnitIndex=j;
                    }
                }
                sum =sum + (l/(maxPerUnitIndex+1))*money[maxPerUnitIndex];
                l = l%(maxPerUnitIndex+1);
                if(l==0)
                    break;
            }
            out.println(sum);
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

