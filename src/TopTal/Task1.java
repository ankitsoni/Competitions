package TopTal;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by asoni on 12/10/2016.
 */
public class Task1 {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        Point3D[] point3Ds = new Point3D[n];
        for (int i = 0; i < n; i++) {
            point3Ds[i] = new Point3D();
            point3Ds[i].x = in.nextInt();
            point3Ds[i].y = in.nextInt();
            point3Ds[i].z = in.nextInt();
        }
        out.println(solve(point3Ds));
        out.close();
    }

    static class Point3D {
        public int x;
        public int y;
        public int z;
    }

    static int solve(Point3D[] A) {
        Set<Long> set = new HashSet<Long>();
        for (int i = 0; i < A.length; i++) {
            long value = (A[i].x * A[i].x) + (A[i].y * A[i].y) + (A[i].z * A[i].z);
            set.add(value);
        }
        return set.size();
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
