import java.io.*;
import java.util.*;

/**
 * Created by asoni on 22-6-16.
 */
public class Amazon1 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int[] a = new int[9];
        int n = in.nextInt();
        List<String> strings = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            strings.add(in.next());
        }
        List<Integer> numbers = new ArrayList<Integer>();
        HashMap<Integer,List<String>> map = new HashMap<Integer,List<String>>();
        for (int i = 0; i < n; i++) {
            int k =0;
            for (int j = 0; j < strings.get(i).length(); j++) {
                char c = strings.get(i).charAt(j);
                int num =0;
                if(c < 'd')
                    num = 2;
                else if(c< 'g')
                    num = 3;
                else if(c< 'j')
                    num = 4;
                else if(c< 'm')
                    num = 5;
                else if(c< 'p')
                    num = 6;
                else if(c< 't')
                    num = 7;
                else if(c< 'w')
                    num = 8;
                else
                    num = 9;
                k = k*10 + num;
            }
            if(!numbers.contains(k))
                numbers.add(k);
            if(map.get(k) != null){
                map.get(k).add(strings.get(i));
                Collections.sort(map.get(k));
            }else{
                List<String> s = new ArrayList<String>();
                s.add(strings.get(i));
                map.put(k,s);
            }
        }
        Collections.sort(numbers);
        for (int i =numbers.size(); i >=0 ; i--) {
            Integer num = numbers.get(i);
            List<String> printst = map.get(num);
//            for (int i = 0; i < printst.size(); i++) {
//                out.println(num+" "+printst.get(i));
//            }
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

    }
}


