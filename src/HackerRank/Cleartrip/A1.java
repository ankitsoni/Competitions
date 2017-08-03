package HackerRank.Cleartrip;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by asoni on 4/2/2017.
 */
public class A1 {
    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = in.next();
        }
        solve(strings);
        out.close();
    }

    static void solve(String[] s) {
//        Arrays.sort(s, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });
        int[][] charCount = new int[s.length][26];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length(); j++) {
                charCount[i][s[i].charAt(j) - 'a']++;
            }
        }
        ArrayList<LinkedList<Integer>> chains = new ArrayList();
        LinkedList<Integer> list = new LinkedList();
        list.add(0);
        chains.add(list);

        for (int i = 1; i < s.length; i++) {
            for (int j = 0; j < chains.size(); j++) {

                LinkedList<Integer> list1 = chains.get(j);
                int index = list1.getLast();
                boolean flag = false;

                int justOnce = 1;
                for (int k = 0; k < 26; k++) {
                    if (charCount[index][k] != charCount[i][k]) {
                        if ((charCount[i][k] - charCount[index][k]) == 1 && justOnce == 1) {
                            justOnce--;
                            continue;
                        } else
                            break;
                    }
                    if (k == 25) {
                        list1.add(i);
                        flag = true;
                    }
                }

                if (!flag && j == (chains.size()-1)) {
                    LinkedList<Integer> newList = new LinkedList();
                    newList.add(i);
                    chains.add(newList);
                }else
                    break;
            }
        }

        int maxChain = 0;

        for (int i = 0; i < chains.size(); i++) {
            if (chains.get(i).size() > maxChain)
                maxChain = chains.get(i).size();
        }
        out.println(maxChain);
    }

    // 6 a b ba bca bda bdca

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
