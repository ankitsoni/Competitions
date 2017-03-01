package TopTal;

import java.io.*;
import java.util.StringTokenizer;

/*
A vending machine has the following denominations: 1c, 5c, 10c, 25c, 50c, and $1.
        Your task is to write a program that will be used in a vending machine to return change.
        Assume that the vending machine will always want to return the least number of coins or notes.
        Devise a function getChange(M, P) where M is how much money was inserted into the machine and P the price of the item selected,
        that returns an array of integers representing the number of each denomination to return.

        Example:
        getChange(5, 0.99) should return [1,0,0,0,0,4]
*/

/*
getChange(3.14, 1.99) should return [0,1,1,0,0,1]
        getChange(4, 3.14) should return [1,0,1,1,1,0]
        getChange(0.45, 0.34) should return [1,0,1,0,0,0]
*/

/**
 * Created by asoni on 12/15/2016.
 */
public class LiveScreening1 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        double M = in.nextDouble();
        double P = in.nextDouble();
        int[] ans = getChange(M,P);
        for (int i = 0; i < ans.length; i++) {
            out.println(ans[i]);
        }
        out.close();
    }

    static int[] getChange(double M,double P){
        int haveCents = (int)(M*100);
        int buyCents = (int)(P*100);
        int left = haveCents -buyCents;
        int[] change = new int[6];

        change[5] = left/100;
        left = left - (change[5]*100);
        change[4] = left/50;
        left = left - (change[4]*50);
        change[3] = left/25;
        left = left - (change[3]*25);
        change[2] = left/10;
        left = left - (change[2]*10);
        change[1] = left/5;
        left = left - (change[1]*5);
        change[0] = left/1;
        left = left - (change[0]*1);
        return change;
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
