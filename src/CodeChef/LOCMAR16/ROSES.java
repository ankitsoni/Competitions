package CodeChef.LOCMAR16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 27-3-16.
 */
public class ROSES {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            int roses = in.nextInt();
            String mood = in.next();
            int[] petals = new int[roses];
            long totalEven = 0, totalOdd = 0, minOdd = 0, oddCount = 0;
            for (int i = 0; i < roses; i++) {
                petals[i] = in.nextInt();
                if (petals[i] % 2 == 0)
                    totalEven += petals[i];
                else {
                    totalOdd += petals[i];
                    if (oddCount == 0)
                        minOdd = petals[i];
                    if (minOdd > petals[i])
                        minOdd = petals[i];
                    oddCount++;
                }
            }
            long total = 0;
            if (mood.equals("Happy")) {
                total = totalEven + totalOdd;
                if (oddCount % 2 == 0)
                    total = total - minOdd;
            } else {
                total = totalEven + totalOdd;
                if (oddCount % 2 == 1)
                    total = total - minOdd;
            }
            if (total == 0)
                out.println("Sad");
            else
                out.println(total);
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