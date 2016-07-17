package TechGig.Allegisjavacontest;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 21-5-16.
 */
public class SchoolFunction {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int a[] = {3,4,-1,6,-1,-1,8};
        int b[] = {1,2,7};
        int i=0,p=0,q=0,x=0,temp=0,temp1=0;
        for(;i<7;i++){
            if(a[p] >b[q]){
                x = p + 1;
                temp = a[p];
                a[p] = b[q];
                q++;
                while(a[x]!=-1 && x<7){
                    temp1 = a[x];
                    a[x] = temp;
                    temp = temp1;
                    x++;
                }
                a[x] =temp;
                p++;
            }
            else if(a[p]==-1){
                a[p]=b[q];
                q++;
                if(q==3)
                    break;
            }else{
                p++;
            }
        }
        for( i =0;i<7;i++){
            out.printf("%d",a[i]);
        }
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

