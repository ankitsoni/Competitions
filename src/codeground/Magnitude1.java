package codeground;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 6/13/2017.
 */
public class Magnitude1 {

    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        Map<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
        for (int i = 0; i < n; i++) {
            String src = in.next();
            String dest = in.next();
            LinkedList<String> dests = map.get(src);
            if (dests == null) {
                dests = new LinkedList<String>();
                map.put(src, dests);
            }
            dests.add(dest);
        }
        int q = in.nextInt();

        for (int i = 0; i < q; i++) {
            String src = in.next();
            String dest = in.next();
            out.println(solve(map, src, dest));
        }
        out.close();
    }

    static int solve(Map<String, LinkedList<String>> map, String src, String dest) {
        int ans = -1;
        if (map.get(src) == null)
            return ans;
        ans = 0;
        HashSet<String> visited = new HashSet<String>();
        visited.add(src);
        LinkedList<String> dests = map.get(src);
        while (dests != null ||!dests.isEmpty()) {
            if (dests.contains(dest))
                return ++ans;
            LinkedList<String> newSet = new LinkedList<String>();
            for (int i = 0; i < dests.size(); i++) {
                LinkedList<String> curr = map.get(dests.get(i));
                for (int j = 0; j < curr.size(); j++) {
                    if (!visited.contains(curr.get(j)))
                        newSet.add(curr.get(j));
                }
            }
            visited.addAll(dests);
            dests = newSet;
            ans++;
        }
        return -1;
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
