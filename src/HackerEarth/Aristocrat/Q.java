package HackerEarth.Aristocrat;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 7/22/2017.
 */
public class Q {

    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int q = in.nextInt();
        Query[] queries = new Query[q];
        for (int i = 0; i < q; i++) {
            queries[i] = new Query();
            queries[i].type = in.nextInt();
            queries[i].x = in.nextInt();
            queries[i].y = in.nextInt();
        }
        solve(arr, queries);
        out.close();
    }

    static void solve(int[] arr, Query[] query) {
        int[] xored = new int[arr.length];
        xored[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            xored[i] = xored[i - 1] ^ arr[i];
        }

        for (int i = 0; i < query.length; i++) {
            if (query[i].type == 0) {
                if (query[i].x == 1) {
                    out.println(xored[0]);
                    continue;
                }
                out.println(xored[query[i].x - 2] ^ xored[query[i].y - 1]);
            } else {
                arr[query[i].x - 1] = arr[query[i].x - 1] ^ query[i].y;
                if (query[i].x == 1) {
                    xored[query[i].x - 1] = arr[0];
                    for (int j = query[i].x; j < xored.length; j++) {
                        if (xored[j] == (xored[j - 1] ^ arr[j])) {
                            break;
                        }
                        xored[j] = xored[j - 1] ^ arr[j];
                    }
                } else {
                    for (int j = query[i].x - 1; j < xored.length; j++) {
                        if (xored[j] == (xored[j - 1] ^ arr[j])) {
                            break;
                        }
                        xored[j] = xored[j - 1] ^ arr[j];
                    }
                }

            }
        }
    }

    static class Query {
        int type;
        int x;
        int y;
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
