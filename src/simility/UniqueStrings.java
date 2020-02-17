package simility;


import java.io.*;
import java.util.*;

public class UniqueStrings {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCases = in.nextInt();
        do {
            String str = in.line();
            int[] charCount = new int[26];

            for (int i = 0; i < str.length(); i++) {
                charCount[str.charAt(i) - 97] += 1;
            }

            List<Char> aChar = getDict(charCount);
            printUniqueStrings(aChar,new StringBuilder(),out);
            out.println(set);
        } while (--testCases > 0);
        out.close();
    }

    public static List<Char> getDict(int[] charCount) {
        List<Char> childChars = new ArrayList<>();
        for (int i = 0; i < charCount.length; i++) {
            if(charCount[i] != 0){
                charCount[i]--;
                Char c = new Char();
                c.setC((char)( i + 97));
                childChars.add(c);
                c.getNextChars().addAll(getDict(charCount.clone()));
                i--;
            }
        }
        return childChars;
    }

    static Set<String> set = new HashSet();

    static void printUniqueStrings(List<Char> charList,StringBuilder sb,PrintWriter out){
        if (sb.length() > 0)
            set.add(sb.toString());

        for(Char c: charList){
            printUniqueStrings(c.getNextChars(),new StringBuilder(sb).append(c.getC()),out);
        }
    }

    static class Char {
        char c;
        List<Char> nextChars = new ArrayList<>();

        public List<Char> getNextChars() {
            return nextChars;
        }

        public void setNextChars(List<Char> nextChars) {
            this.nextChars = nextChars;
        }

        public char getC() {
            return c;
        }

        public void setC(char c) {
            this.c = c;
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
