package CodeChef.APRIL16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 5-4-16.
 */
public class FIBQ {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        char[] query = new char[m];
        int[] pos1 = new int[m];
        int[] pos2 = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            query[i] = in.next().charAt(0);
            pos1[i] = in.nextInt();
            pos2[i] = in.nextInt();
        }
        long[] fibo = new long[1000];
        long n1=0l,n2=1l,n3 = 0l;
        fibo[0] = 0l;
        fibo[1] = 1l;

        for(int i=2;i<1000;i++)
        {
            n3=(n1+n2)%1000000007;
            fibo[i] = n3 ;
            n1=n2;
            n2=n3;
        }
        long printLong = 0l;
        for (int i = 0; i < m; i++) {
            if(query[i] == 'C')
                arr[pos1[i]-1] = pos2[i];
            else{
                printLong = powerSet(arr,pos1[i],pos2[i],fibo);
                out.println(printLong);
            }
        }
        out.close();
    }
    static long powerSet (int[] arr,int pos1,int pos2,long[] fibo){
        int currentSubset = (int)Math.pow(2,pos2-pos1+1)-1,tmp = 0;
        int[] sum = new int[currentSubset];
        long result = 0l;
        while(currentSubset > 0) {
            tmp = currentSubset;
            for (int i = 0; i < pos2-pos1+1; i++) {
                if ((tmp & 1) > 0){
                    sum[currentSubset-1] +=arr[i+pos1-1];
                }
                tmp >>= 1;
            }
            currentSubset--;
        }
        for (int i = 0; i < sum.length; i++) {
            result += fibo[sum[i]] % 1000000007;
        }
        return result;
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
