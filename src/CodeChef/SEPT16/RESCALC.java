package CodeChef.SEPT16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 9/9/2016.
 */
public class RESCALC {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            int n = in.nextInt();
            int[] c = new int[n];
            int[] points = new int[n];
            int maxPos = 0, secMaxPos = 0, maxPoints = 0, secMaxPoints = 0;
            int[][] type = new int[n][6];


            for (int i = 0; i < n; i++) {
                c[i] = in.nextInt();
                for (int j = 0; j < c[i]; j++) {
                    type[i][in.nextInt() - 1] = 1;
                }
            }

            for (int i = 0; i < n; i++) {
                points[i] += c[i];
                int trueCount = 0;
                for (int j = 0; j < 6; j++) {
                    trueCount += type[i][j];
                }
                points[i] = trueCount == 4 ? points[i] + 1 : (trueCount == 5 ? points[i] + 2 : (trueCount == 6 ? points[i] + 4 : points[i]));
            }
            for (int i = 0; i < n; i++) {
                if (points[i] >= maxPoints) {
                    secMaxPoints = maxPoints;
                    maxPoints = points[i];
                    secMaxPos = maxPos;
                    maxPos = i;
                } else if (points[i] > secMaxPoints) {
                    secMaxPoints = points[i];
                    secMaxPos = i;
                }
            }
            if(maxPoints > secMaxPoints){
                if(maxPos == 0){
                    out.println("chef");
                }else
                    out.println(maxPos + 1);
            }else
                out.println("tie");

            for (int i = 0; i < n; i++) {
                out.println(i+":"+points[i]);
            }
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

    }
}

