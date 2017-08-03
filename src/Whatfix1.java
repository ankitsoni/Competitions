import java.io.*;
import java.util.*;
import java.lang.*;

/**
 * Created by asoni on 7/29/2017.
 */
public class Whatfix1 {
    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static Node parent = null;
    static List list = new ArrayList();

    public static void main(String[] args) {
        Node[] nodes = new Node[34];
        for (int i = 1; i <= 33; i++) {
            Node node = new Node();
            node.x = i;
            node.left = null;
            node.right = null;
            nodes[i] = node;
        }
        setNodes(nodes);
        //inorder(nodes[17]);
        int a = 29;
        int b = 17;
        solve(nodes[17], a, b);
        out.close();
    }

    static void solve(Node root, int a, int b) {
        findParent(root, a, b);
        printLeft(parent.left, a, b);
        out.println(parent.x);
        printRight(parent.right,a,b);
    }

    static boolean printLeft(Node node, int a, int b) {
        if (node == null) {
            return false;
        }
        boolean l = printLeft(node.left, a, b);
        boolean r = printLeft(node.right, a, b);
        boolean c = node.x == a || node.x == b;
        if (l || r || c) {
            out.println(node.x);
            return true;
        }
        return false;
    }

    static boolean printright(Node node, int a, int b) {
        if (node == null) {
            return false;
        }
        boolean l = printright(node.left, a, b);
        boolean r = printright(node.right, a, b);
        boolean c = node.x == a || node.x == b;
        if (l || r || c) {
            list.add(node.x);
            return true;
        }
        return false;
    }

    static void printRight(Node node, int a, int b){
        printright(node,a,b);
        for (int i = list.size()-1; i >= 0; i--) {
            out.println(list.get(i));
        }
    }

    static boolean findParent(Node root, int a, int b) {
        if (root == null) {
            return false;
        }
        boolean l = findParent(root.left, a, b);
        boolean r = findParent(root.right, a, b);
        boolean c = root.x == a || root.x == b;
        if ((l && r && parent == null) || (l && c && parent == null) || (c && r && parent == null)) {
            parent = root;
            return false;
        } else if (l || r || c) {
            return true;
        }
        return false;
    }

    static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        out.println(node.x + " ");
        inorder(node.right);
    }

    static class Node {
        int x;
        Node left;
        Node right;
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

    static void setNodes(Node[] nodes) {
        nodes[1].left = null;
        nodes[2].left = nodes[1];
        nodes[3].left = null;
        nodes[4].left = nodes[2];
        nodes[5].left = null;
        nodes[6].left = nodes[5];
        nodes[7].left = null;
        nodes[8].left = nodes[4];
        nodes[9].left = null;
        nodes[10].left = nodes[9];
        nodes[11].left = null;
        nodes[12].left = nodes[10];
        nodes[13].left = null;
        nodes[14].left = nodes[13];
        nodes[15].left = null;
        nodes[16].left = nodes[15];
        nodes[17].left = nodes[8];
        nodes[18].left = null;
        nodes[19].left = nodes[18];
        nodes[20].left = null;
        nodes[21].left = nodes[19];
        nodes[22].left = null;
        nodes[23].left = nodes[22];
        nodes[24].left = null;
        nodes[25].left = nodes[21];
        nodes[26].left = null;
        nodes[27].left = nodes[26];
        nodes[28].left = null;
        nodes[29].left = nodes[27];
        nodes[30].left = null;
        nodes[31].left = nodes[30];
        nodes[32].left = null;
        nodes[33].left = null;


        nodes[1].right = null;
        nodes[2].right = nodes[3];
        nodes[3].right = null;
        nodes[4].right = nodes[6];
        nodes[5].right = null;
        nodes[6].right = nodes[7];
        nodes[7].right = null;
        nodes[8].right = nodes[12];
        nodes[9].right = null;
        nodes[10].right = nodes[11];
        nodes[11].right = null;
        nodes[12].right = nodes[14];
        nodes[13].right = null;
        nodes[14].right = nodes[16];
        nodes[15].right = null;
        nodes[16].right = null;
        nodes[17].right = nodes[25];
        nodes[18].right = null;
        nodes[19].right = nodes[20];
        nodes[20].right = null;
        nodes[21].right = nodes[23];
        nodes[22].right = null;
        nodes[23].right = nodes[24];
        nodes[24].right = null;
        nodes[25].right = nodes[29];
        nodes[26].right = null;
        nodes[27].right = nodes[28];
        nodes[28].right = null;
        nodes[29].right = nodes[31];
        nodes[30].right = null;
        nodes[31].right = nodes[32];
        nodes[32].right = nodes[33];
        nodes[33].right = null;
    }
}

