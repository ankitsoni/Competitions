package Brisky;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by asoni on 1/19/2017.
 */
public class A2 {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int votes = in.nextInt();
        String[] candi = new String[votes];
        for (int i = 0; i < votes; i++) {
            candi[i] = in.next();
        }
        out.println(winner(candi));
        out.close();
    }

    static String winner(String[] canndidates) {
        int maxVotes = 0;
        int last = 0;
        String winner  = null;
        Arrays.sort(canndidates);
        for (int i = 1; i < canndidates.length; i++) {
            if (!canndidates[i].equals(canndidates[i - 1])) {

                if (i - last >= maxVotes) {
                    winner = canndidates[i - 1];
                    maxVotes = i - last;
                    last = i;
                }
            }
        }
        if(canndidates.length - last >= maxVotes){
            winner = canndidates[canndidates.length -1];
        }
        return winner;
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

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}
