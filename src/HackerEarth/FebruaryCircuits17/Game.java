package HackerEarth.FebruaryCircuits17;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 2/20/2017.
 */
public class Game {
    static class Position {
        int x;
        int y;
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            int n = in.nextInt();
            int q = in.nextInt();
            List<Position> positions = new ArrayList<Position>();
            for (int i = 0; i < q; i++) {
                Position position = new Position();
                position.x = in.nextInt();
                position.y = in.nextInt();
                positions.add(position);
            }
            Collections.sort(positions, new Comparator<Position>() {
                @Override
                public int compare(Position o1, Position o2) {
                    if (o1.x != o2.x)
                        return o1.x - o2.x;
                    return o1.y - o2.y;
                }
            });
            out.println(solve(positions, n));
        }
        while (--t > 0);
        out.close();
    }

    static int solve(List<Position> pos, int n) {
        for (int i = 0; i < pos.size(); i++) {
            if (i < pos.size() - 2 && pos.get(i).x == pos.get(i + 1).x &&
                    pos.get(i).x == pos.get(i + 2).x) {
                return pos.get(i).x - 1;
            }
            if (i > 0 && i < pos.size() - 2 && (
                    (pos.get(i - 1).y == 1 && pos.get(i).y == 2 && pos.get(i + 1).y == 2 && pos.get(i + 2).y == 3
                            && pos.get(i - 1).x == pos.get(i).x && pos.get(i + 1).x == pos.get(i + 2).x &&
                            pos.get(i).x + 1 == pos.get(i + 1).x)
                            || (pos.get(i - 1).y == 2 && pos.get(i).y == 3 && pos.get(i + 1).y == 1 && pos.get(i + 2).y == 2
                            && pos.get(i - 1).x == pos.get(i).x && pos.get(i + 1).x == pos.get(i + 2).x &&
                            pos.get(i).x + 1 == pos.get(i + 1).x)))
            return pos.get(i).x;
        }
        return n;
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
