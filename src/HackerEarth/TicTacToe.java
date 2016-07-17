package HackerEarth;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 12-3-16.
 * https://www.hackerearth.com/problem/multiplayer/tic-tac-toe/
 */
public class TicTacToe {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int[] arr = new int[9];
        Map sumMap = new HashMap();
        sumMap.put(8, 1);
        sumMap.put(3, 2);
        sumMap.put(4, 3);
        sumMap.put(1, 4);
        sumMap.put(5, 5);
        sumMap.put(9, 6);
        sumMap.put(6, 7);
        sumMap.put(7, 8);
        sumMap.put(2, 9);
        int[] sumMatrix = {8, 3, 4, 1, 5, 9, 6, 7, 2};
        int myCount = 0, enemyCount = 0, filledPositions = 0, myFilled = 0, enemyFilled = 0;
        List list = new ArrayList();
        for (int i = 0; i < 9; i++) {
            arr[i] = in.nextInt();
        }
        int id = in.nextInt();
        for (int i = 0; i < 9; i++) {
            if (arr[i] == 0) {
                list.add(sumMatrix[i]);
                continue;
            } else if (arr[i] == id) {
                myFilled++;
                myCount += sumMatrix[i];
            } else {
                enemyFilled++;
                enemyCount += sumMatrix[i];
            }
        }
        if (myCount < 15 && myFilled > 1 && list.contains(15 - myCount))
            out.print(sumMap.get(15 - myCount));
        else if (enemyCount < 15 && enemyFilled > 1 && list.contains(15 - enemyCount))
            out.print(sumMap.get(15 - enemyCount));
        else if(myCount < 10 && list.contains(5))
            out.println("1 1");
        else
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


