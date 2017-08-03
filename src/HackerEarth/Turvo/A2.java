package HackerEarth.Turvo;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 3/19/2017.
 */
public class A2 {

    static List<Node> nodes = new LinkedList<Node>();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.nextInt();
            int t = in.nextInt();
            Node node = new Node(5);
            do {
                String str = in.next();
                if (str.equals("S")) {
                    int k = in.nextInt();
                    Node.printSize(k);
                } else if (str.equals("M")) {
                    int k = in.nextInt();
                    int l = in.nextInt();
                    Node.merge(k - 1, l - 1);
                }
            } while (--t > 0);
        }catch (Exception e){
            out.println(e.getMessage());
        }
        out.close();
    }

    static class Node {
        static int[] company, parentCompany;
        static int n;

        public Node(int n) {
            company = new int[n];
            parentCompany = new int[n];
            this.n = n;
            makeSet();
        }

        void makeSet() {
            for (int i = 0; i < n; i++) {
                parentCompany[i] = i;
            }
        }

        static int find(int x) {
            if (parentCompany[x] != x) {
                parentCompany[x] = find(parentCompany[x]);
            }
            return parentCompany[x];
        }

        static void merge(int x, int y) {
            int xRoot = find(x), yRoot = find(y);

            if (xRoot == yRoot)
                return;
            if (company[xRoot] < company[yRoot]){
                parentCompany[xRoot] = yRoot;
            }

            else if (company[yRoot] < company[xRoot])
                parentCompany[yRoot] = xRoot;

            else {
                parentCompany[yRoot] = xRoot;
                company[xRoot] = company[xRoot] + 1;
            }
        }

        static void printSize(int key) {
            int pos = find(key - 1);
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (parentCompany[i] == pos)
                    count++;
            }
            out.println(count);
        }
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
