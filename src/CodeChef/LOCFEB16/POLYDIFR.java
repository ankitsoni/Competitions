package CodeChef.LOCFEB16;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by asoni on 27-2-16.
 */
public class POLYDIFR {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            StringBuilder sb = new StringBuilder();
            int N = in.nextInt();
            int[] a = new int[N], p = new int[N];
            long[] result = new long[N];
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
                p[i] = in.nextInt();

                if (p[i] > 0) {
                    result[i] = a[i] * p[i];
                    p[i]--;
                }else{
                    result[i]=0;
                }
            }
            // sort acc to max power
            int maxPower = 0,tempInt=0;
            long temp = 0;
            for (int i = 0; i < N; i++) {
                maxPower = p[i];
                for (int j = i + 1; j < N; j++) {
                    if (p[j] > maxPower) {
                        tempInt = p[i];
                        p[i] = p[j];
                        p[j] = tempInt;
                        temp = result[i];
                        result[i] = result[j];
                        result[j] = temp;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                if (result[i] > 0 && p[i] > 0) {
                    if (sb.length() > 0)
                        sb.append(" + ");
                    sb.append(result[i] + "x^" + p[i]);
                }
                if (p[i] == 0 && result[i] > 0) {
                    if (sb.length() > 0)
                        sb.append(" + ");
                    sb.append(result[i]);
                }
                if(sb.length()==0)
                    sb.append(0);
            }
            out.println(sb);
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




/* Working Code with unordered exponent

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder();
        int t = in.nextInt();
        do {
            int N = in.nextInt();
            int[] a = new int[N],p = new int[N];
            long[] result = new long[N];
            for (int i=0;i<N;i++){
                a[i] = in.nextInt();
                p[i] = in.nextInt();

                if(p[i]>0){
                    result[i] = a[i]*p[i];
                    p[i]--;
                }
            }
            for (int i=0;i<N;i++){
                if(result[i] > 0 && p[i] > 0){
                    if(sb.length()>0)
                        sb.append(" + ");
                    sb.append(result[i]+"x^"+p[i]);
                }
                if(p[i]==0 && result[i]>0){
                    if(sb.length()>0)
                        sb.append(" + ");
                    sb.append(result[i]);
                }
            }

        }while (--t>0);
        out.println(sb);
        out.close();
    }*/
