package HackerEarth;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 22-5-16.
 */
public class RodCuttingProblem {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int[] twoPowers = {4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072,262144,524288,1048576,
2097152,4194304,8388608,16777216,33554432,67108864,134217728,268435456,536870912,1073741824};
        int t = in.nextInt();
        int[] n = new int[t];
        for (int i = 0; i < t; i++) {
            n[i] = in.nextInt();
        }
        for (int i = 0; i < t; i++) {
            if(n[i]==1 || n[i]==2){
                out.println(0);
                continue;
            }
            int count =0;
            for (int j = 0; j < 32; j++) {
                if(n[i]>=twoPowers[j]){
                    count++;
                    continue;
                }else{
                    count = (n[i]==twoPowers[j]-1 || n[i] == twoPowers[j])? ++count : count;
                    out.println(count);
                    break;
                }
            }
        }
       /* for (int i = 0; i < t; i++) {
            if(n[i]==1 || n[i]==2){
                out.println(0);
                continue;
            }
            for (int j = 0; j < 32; j++) {
                if(n[i]>twoPowers[j]){
                    continue;
                }else if(n[i] == twoPowers[j]){
                    out.println(twoPowers[j-1]-1);
                    break;
                }else{
                    int distace = twoPowers[j-2] - (twoPowers[j]-n[i]) +1;
                    distace = distace<0 ? 0 : distace;
                    int res = twoPowers[j-2] -1 + distace;
                    out.println(res);
                    break;
                }
            }
        }*/
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