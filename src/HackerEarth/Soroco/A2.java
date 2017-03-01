package HackerEarth.Soroco;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 2/19/2017.
 */
public class A2 {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int q = in.nextInt();
        long[] arr = new long[n];
        int[] qType = new int[q];
        int[] set = new int[q];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        for (int i = 0; i < q; i++) {
            qType[i] = in.nextInt();
            set[i] = in.nextInt();
        }
        out.println(solve(n, q, arr, qType, set));
        out.close();
    }


    static String solve(int n, int q, long[] arr, int[] type, int[] set) {
        StringBuilder sb = new StringBuilder();
        int[] num = new int[10];
        for (int i = 0; i < n; i++) {
            int value = 0;
            while (arr[i] >= 10) {
                value=0;
                value += arr[i] % 10;
                arr[i] = arr[i] / 10;
                arr[i]+=value;
            }
            num[(int)arr[i]]++;
        }

        for (int i = 0; i < q; i++) {

            int answer = 0;
            if(type[i] == 1){
                int start = 9;
                while (set[i] != 0){
                    if(num[start] >= set[i]){
                        answer+= start*set[i];
                        break;
                    }else{
                        answer+= start*num[start];
                        set[i] -= num[start];
                        start--;
                    }
                }
            }else{
                int start = 1;
                while (set[i] != 0){
                    if(num[start] >= set[i]){
                        answer+= start*set[i];
                        break;
                    }else{
                        answer+= start*num[start];
                        set[i] -= num[start];
                        start++;
                    }
                }
            }
            sb.append(answer+"\n");
        }

        return sb.toString();
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
