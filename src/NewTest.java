import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 7/30/2016.
 */
public class NewTest {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String s = in.next();
        out.println(solve(s));
        out.close();
    }

    static String solve(String s){
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if((int)s.charAt(i) < 97){
                st.append((char)( s.charAt(i)+32));
            }else{
                st.append((char)( s.charAt(i)-32));
            }
        }
        return st.toString();
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


