package HackerEarth.BlueOptima_InterviewCall;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 6-7-16.
 */
public class Q1 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        try {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            out.println(solve(arr,n));
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.close();
    }

    static int solve(int[] arr,int n) {
        int count =0;
        if(n<3)
            return 0;
        for (int i = 0; i < n; i++) {
            int lastPos=i+1;
            int currSum=0;
            for (int j = i+1; j < n ; j++) {
                currSum = arr[i]+arr[j];
                for (int k = lastPos; k < n && currSum >arr[k]; k++,lastPos++) {
                    if(arr[k]==currSum){
                        count++;
                        break;
                    }
                }
                if(lastPos==n-1 || currSum>arr[n-1]){
                    break;
                }
            }
        }
        return count;
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


