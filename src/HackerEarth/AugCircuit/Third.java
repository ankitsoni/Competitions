package HackerEarth.AugCircuit;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by asoni on 8/21/2016.
 */
public class Third {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int node = in.nextInt();
        int edge = in.nextInt();
        Map<Integer, Map<Integer, Integer>> mapMap = new HashMap<Integer, Map<Integer, Integer>>();
        for (int i = 0; i < node; i++) {
            Map<Integer, Integer> integerIntegerMap = new HashMap<Integer, Integer>();
            mapMap.put(i + 1, integerIntegerMap);
        }
        for (int i = 0; i < edge; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            mapMap.get(from).put(i + 1, to);
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

    }
}

