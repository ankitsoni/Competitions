package CodeForces;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 19-3-16.
 */
public class B653 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int q = in.nextInt();
        Map<String, String> stringStringHashMap = new HashMap<String, String>();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < q; i++) {
            String a, b;
            a = in.next();
            b = in.next();
            stringStringHashMap.put(a,b);
            if(b.equals("a"))
                list.add(a);
        }
        for (int i = 0; i < n-2; i++) {
            int listsize =list.size();
            for (int j = 0; j < listsize ; j++) {
                String currentString = list.get(j).substring(0,2);
                for (int k = 0; k < stringStringHashMap.size(); k++) {
                    if(stringStringHashMap.get(list.get(k)).charAt(0)== currentString.charAt(0)){
                        list.add(currentString+list.get(j).substring(1,list.get(j).length()));
                    }
                }
            }
        }
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
//for (int i = 0; i < n - 2; i++) {
//        for (int j = 0; j < list.size(); j++) {
//        List<String> stringList = new ArrayList<String>();
//        stringList = stringStringHashMap.get(list.get(j));
//        for (String string :stringList) {
//        stringStringHashMap.put(string,list.get(j).substring(0,2)+string)
//        }
//        }
//        }