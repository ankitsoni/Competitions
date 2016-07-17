package HackerEarth.practice.algorithms.dynamic_programming;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by asoni on 23-6-16.
 */
public class XsquareAndTwoArrays {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        try{
            int n = in.nextInt();
            int t = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            long[] aFirstSum = new long[n];
            long[] bFirstSum = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
            }
            aFirstSum[0] =a[0];
            bFirstSum[0] =b[0];
            for (int i = 1; i < n; i++) {
                aFirstSum[i] =b[i]+aFirstSum[i-1];
                if(++i<n)
                    aFirstSum[i] =a[i]+aFirstSum[i-1];
            }
            for (int i = 1; i < n; i++) {
                bFirstSum[i] =a[i]+bFirstSum[i-1];
                if(++i<n)
                    bFirstSum[i] =b[i]+bFirstSum[i-1];
            }
            do {
                int type = in.nextInt();
                int pos1 = in.nextInt();
                int pos2 =in.nextInt();
                long res = solve(aFirstSum,bFirstSum,type,pos1,pos2);
                out.println(res);
            } while (--t > 0);
        }catch (Exception e){
            e.printStackTrace();
        }
        out.close();
    }

    static long solve(long[] aSum,long[] bSum,int type,int pos1,int pos2){
        long  res=0;
        if(type==1){
            if(pos1%2==1){
                if(pos1-2>=0)
                    res = aSum[pos2-1] - aSum[pos1-2];
                else
                    res = aSum[pos2-1];
            }else{
                if(pos1-2>=0)
                    res = bSum[pos2-1] - bSum[pos1-2];
                else
                    res = bSum[pos2-1];
            }
        }else if(type == 2){
            if(pos1%2==1){
                if(pos1-2>=0)
                    res = bSum[pos2-1] - bSum[pos1-2];
                else
                    res = bSum[pos2-1];
            }else{
                if(pos1-2>=0)
                    res = aSum[pos2-1] - aSum[pos1-2];
                else
                    res = aSum[pos2-1];
            }
        }
        return res;
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



