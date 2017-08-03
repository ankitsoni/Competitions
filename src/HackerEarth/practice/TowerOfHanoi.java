package HackerEarth.practice;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 3/2/2017.
 */
public class TowerOfHanoi {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            int n = in.nextInt();
            List<Node> nodes = new ArrayList<Node>();
            for (int i = 0; i < n; i++) {
                Node node = new Node();
                node.r = in.nextInt();
                node.h = in.nextInt();
                nodes.add(node);
            }
            out.println(solve(nodes));
        } while (--t > 0);
        out.close();
    }

    static class Node {
        int r;
        int h;
    }

    static long solve(List<Node> nodes) {
        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                int a = o1.r + o1.h;
                int b = o2.r + o2.h;
                if (a != b)
                    return b- a;
                return o1.h - o2.h;
            }
        });
        long currentHeight = nodes.get(0).h;
        long sumHeight = nodes.get(0).h;
        for (int i = 1; i < nodes.size(); i++) {
            currentHeight = nodes.get(i).h;
            if (currentHeight > sumHeight)
                sumHeight = currentHeight;
            else if (nodes.get(i).h < nodes.get(i - 1).h)
                sumHeight += currentHeight;
        }
        return sumHeight;
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

//2
//        3
//        4 3
//        1 4
//        3 2
//        5
//        5 6
//        4 3
//        1 2
//        7 5
//        3 4

