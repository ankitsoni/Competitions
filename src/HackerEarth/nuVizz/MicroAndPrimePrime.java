/*
package HackerEarth.nuVizz;

import java.io.*;
import java.util.StringTokenizer;

*/
/**
 * Created by asoni on 3-7-16.
 *//*

public class MicroAndPrimePrime {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        try {
            int t = in.nextInt();
            do {
                String minutes = in.next();
                globalString = globalString + minutes;
                int res = solve(minutes);
                if (res > maxStreak) {
                    maxStreak = res;
                }
            } while (--t > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.close();
    }

    static int solve(String minutes) {
        int pos1 = 0, pos2 = 0, maxStreak = 0;
        for (int i = 0; i < minutes.length(); i++) {
            if (minutes.charAt(i) == 'C') {
                pos1 = i++;
                while (i < minutes.length() && minutes.charAt(i) == 'C') {
                    i++;
                }
                pos2 = --i;
                if (pos2 - pos1 + 1 > maxStreak) {
                    maxStreak = pos2 - pos1 + 1;
                }
            }
        }
        return maxStreak;
    }

    static int solveDays(String days, int maxStreak) {
        String code = new String();
        int pos1 = 0,pos2=0;
        for (int i = 0; i < maxStreak; i++) {
            code = code + "C";
        }
        do {
            if (days.contains(code)) {
                pos1 = days.indexOf(code);
                code = code + "C";
                continue;
            } else {
                break;
            }

        } while (true);
        int i = pos1;
        do {
            if(i < days.length() && days.charAt(i)=='C'){
                pos2 = i++;
                continue;
            }else{
                break;
            }
        } while (i < days.length());
        return pos2-pos1+1;
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


*/
