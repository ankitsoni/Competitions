package Google.CodeJam8April2016;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 30-4-16.
 */
public class GettingTheDigits {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        int counter = 1;
        do {
            String s = in.next();
            int[] charCount = new int[128];
            int[] arr = new int[10];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                charCount[c]++;
            }
            if(charCount['Z'] > 0){
                arr[0] = arr[0] + charCount['Z'];
                charCount['E'] = charCount['E'] - charCount['Z'];
                charCount['R'] = charCount['R'] - charCount['Z'];
                charCount['O'] = charCount['O'] - charCount['Z'];
                charCount['Z'] = charCount['Z'] - charCount['Z'];
            }
            if(charCount['U'] > 0){
                arr[4] = arr[4] + charCount['U'];
                charCount['F'] = charCount['F'] - charCount['U'];
                charCount['O'] = charCount['O'] - charCount['U'];
                charCount['R'] = charCount['R'] - charCount['U'];
                charCount['U'] = charCount['U'] - charCount['U'];
            }
            if(charCount['X'] > 0){
                arr[6] = arr[6] + charCount['X'];
                charCount['S'] = charCount['S'] - charCount['X'];
                charCount['I'] = charCount['I'] - charCount['X'];
                charCount['X'] = charCount['X'] - charCount['X'];
            }
            if(charCount['G'] > 0){
                arr[8] = arr[8] + charCount['G'];
                charCount['E'] = charCount['E'] - charCount['G'];
                charCount['I'] = charCount['I'] - charCount['G'];
                charCount['H'] = charCount['H'] - charCount['G'];
                charCount['T'] = charCount['T'] - charCount['G'];
                charCount['G'] = charCount['G'] - charCount['G'];
            }
            if(charCount['W'] > 0){
                arr[2] = arr[2] + charCount['W'];
                charCount['T'] = charCount['T'] - charCount['W'];
                charCount['O'] = charCount['O'] - charCount['W'];
                charCount['W'] = charCount['W'] - charCount['W'];
            }
            if(charCount['S'] > 0){
                arr[7] = arr[7] + charCount['S'];
                charCount['E'] = charCount['E'] - charCount['S'];
                charCount['V'] = charCount['V'] - charCount['S'];
                charCount['E'] = charCount['E'] - charCount['S'];
                charCount['N'] = charCount['N'] - charCount['S'];
                charCount['S'] = charCount['S'] - charCount['S'];
            }
            if(charCount['H'] > 0){
                arr[3] = arr[3] + charCount['H'];
                charCount['T'] = charCount['T'] - charCount['H'];
                charCount['R'] = charCount['R'] - charCount['H'];
                charCount['E'] = charCount['E'] - charCount['H'];
                charCount['E'] = charCount['E'] - charCount['H'];
                charCount['H'] = charCount['H'] - charCount['H'];
            }
            if(charCount['F'] > 0){
                arr[5] = arr[5] + charCount['F'];
                charCount['I'] = charCount['I'] - charCount['F'];
                charCount['V'] = charCount['V'] - charCount['F'];
                charCount['E'] = charCount['E'] - charCount['F'];
                charCount['F'] = charCount['F'] - charCount['F'];
            }
            if(charCount['O'] > 0){
                arr[1] = arr[1] + charCount['O'];
                charCount['N'] = charCount['N'] - charCount['O'];
                charCount['E'] = charCount['E'] - charCount['O'];
                charCount['O'] = charCount['O'] - charCount['O'];
            }
            if(charCount['I'] > 0){
                arr[9] = arr[9] + charCount['I'];
                charCount['N'] = charCount['N'] - charCount['I'];
                charCount['N'] = charCount['N'] - charCount['I'];
                charCount['E'] = charCount['E'] - charCount['I'];
                charCount['I'] = charCount['I'] - charCount['I'];
            }
            out.print("Case #"+(counter++)+": ");
            for (int i = 0; i < 10; i++) {
                for (int j = 0; arr[i] > 0; j++) {
                    out.print(i);
                    arr[i]--;
                }
            }
            out.println();
        } while (--t > 0);
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

    }
}

