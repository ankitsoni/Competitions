package TopTal;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by asoni on 5/7/2017.
 */
public class AnujT1 {

    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        AnujT1 a = new AnujT1();
        out.println(a.solution(A));
        out.close();
    }

    //7 1 2 5 5 4 5 5
    public boolean solution(int[] A) {
        boolean flag = false;
        int count = 0;
        if (A.length <= 2) {
            return true;
        }
        for (int i = 0, j = 1; j < A.length; i++, j++) {
            if (A[i] > A[j]) {
                int k = i;
                while (k > 0 && A[k] == A[k-1]){
                    k--;
                }
                i = k;
                if (i != 0 && A[i - 1] < A[j])
                    count++;
                else
                    count += 5;
                i = j-1;
            }
        }
        if (count <= 1)
            return true;
        return false;
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
