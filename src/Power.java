import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 16-2-16.
 */
public class Power {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int i, j, k, mul, result = 1;
            int[] arr = new int[1000];
            if (b == 1) {
                out.print(a);
                out.close();
                return;
            }
            for (j = 0, i = 1, mul = a; i <= b; i = i * 2, j++, mul = mul * mul) {
                arr[j] = mul;
            }
            for (i = i / 2, k = j - 1; k >= 0; k--, i = i / 2) {
                if (b / i >= 1) {
                    result = result * arr[k];
                    b = b - i;
                }
            }
            out.print(result);
            out.flush();
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

    }
}
