package CodeChef.MARCH17;
import java.io.*;
import java.util.*;

/**
 * Created by asoni on 3/5/2017.
 */
public class SCHEDULE {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        do {
            int n = in.nextInt();
            int k = in.nextInt();
            String str = in.next();
            out.println(solve(n, k, str));
        } while (--t > 0);
        out.close();
    }

    static int solve(int n, int k, String str) {
        if (n == 1) {
            return 1;
        }
        Integer[] arr = getCountArray(str);
        for (int i = 0; i < k; i++) {
            heapify(arr, arr.length, 0);
            if (arr[0] == 1)
                break;
            arr[0] = arr[0] / 2;
        }
        heapify(arr, arr.length, 0);
        return arr[0];
    }

    static void heapify(Integer arr[], int n, int i) {

        int largest = i;  // Initialize largest as root
        int l = 2 * i + 1;  // left = 2*i + 1
        int r = 2 * i + 2;  // right = 2*i + 2

        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }

    }

    static Integer[] getCountArray(String str) {
        List<Integer> integerList = new ArrayList<Integer>();
        char c = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            } else {
                integerList.add(count);
                c = str.charAt(i);
                count = 1;
            }
        }
        integerList.add(count);
        Integer[] integerArray = Arrays.copyOf(integerList.toArray(), integerList.size(), Integer[].class);
        return integerArray;
                //integerList.stream().filter(t -> t != null).mapToInt(t -> t).toArray();
    }


//    static StringBuilder getCountString(String str){
//        StringBuilder sb = new StringBuilder();
//        char c = str.charAt(0);
//        int count = 1;
//        for (int i = 1; i < n; i++) {
//            if (str.charAt(i) == c) {
//                count++;
//            } else {
//                sb.append(count);
//                c = str.charAt(i);
//                count = 1;
//            }
//        }
//        sb.append(count);
//        return sb;
//    }

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
