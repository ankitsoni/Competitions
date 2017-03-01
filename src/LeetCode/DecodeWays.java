package LeetCode;

import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by asoni on 8/9/2016.
 */
public class DecodeWays {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String s = in.next();
        out.println(solve(s));
        out.close();
    }

    static int solve(String s) {
        int[] num = new int[s.length()];
        int[] sum = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            num[i] = Character.getNumericValue(s.charAt(i));
        }

        if(s.length()==0)
            return 0;
        else if(s.length()==1)
            return 1;
        sum[0] = 1;
        if(num[0]==1 || (num[0]==2 && num[1]<=6))
            sum[1] = 2;
        else
            sum[1] = 1;
        for (int i = 2; i < num.length; i++) {
            if(num[i-1]==1 || (num[i-1]==2 && num[1]<=6))
                sum[i] = sum[i-1] + sum[i-2];
            else
                sum[i] = sum[i-1];
        }
        return sum[num.length - 1];
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

    }
}


