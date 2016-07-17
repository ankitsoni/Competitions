package TechGig.CodeGladiator;

import java.io.*;
import java.util.*;

/**
 * Created by asoni on 30-3-16.
 */
public class MediumLevel {
    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {

        int n = in.nextInt();
        int[] heig = new  int[n];
        for (int i = 0; i < n; i++) {
            heig[i] = in.nextInt();
        }
        int[] or = uniqueValue(n,heig);
        out.println(or[0]);
        out.close();
    }
    public static int[] uniqueValue(int n,int[] height)
    {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        List<Integer> integerList = new ArrayList<Integer>();
        int[] order = new int[n];
        int[] count = new int[n];
        int k =0;
        for (int i = 0; i < n; i++) {
            if(count[height[i]]==0){
                map.put(height[i],i+1);
            }
            else
                integerList.add(height[i]);
            count[height[i]]++;
        }
        Collections.sort(integerList);
        int[] sorte = new int[integerList.size()];
        for (int i = 0; i < integerList.size(); i++) {
            int currHeigt = integerList.get(i);
            for (int j = 0,t=0; j < n; j++) {
                if(height[j] == currHeigt){
                    t++;
                    if(t!=1){
                        sorte[i] = j+1;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(map.get(i)!= null )
                order[i] = map.get(i);
            else{
                order[i] = sorte[k];
                k++;
            }
        }
        return order;
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

