package MarketShare;

import java.io.*;
import java.nio.charset.Charset;
import java.util.StringTokenizer;

/**
 * Created by asoni on 26-5-16.
 */
public class Odometer {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        double hod =0.0;
        double grid =0.0;
        int predict = 0;
        String line;
        int count= 0;
    try {
        InputStream fis = new FileInputStream("D:\\pgit\\Competitions\\src\\MarketShare\\SacramentoCrimeJanuary2006.csv");
        InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
        BufferedReader br = new BufferedReader(isr);
        line = br.readLine();
        while ((line = br.readLine()) != null ) {
            String[] k= line.split(",");
            String[] x = k[0].split("/");
            String[] y = x[2].split(" ");
            String[] z = y[1].split(":");
            int  h = Integer.valueOf(z[0]);
            double min =0.0;
                min = Integer.valueOf(z[1]) >= 30 ?0.5:0.0;
            hod = h+min;
            grid = Double.valueOf(k[4]);
            int fpredict = Integer.valueOf(k[6]);

            if(hod <= 6.5){
                if(grid <= 627.0){
                    if(grid <= 619.5){
                        predict = 2404;
                    }else{
                        predict = 2299;
                    }
                }else{
                    predict = 7000;
                }
            }else if(hod <= 16.5){
                predict = 7000;
            }else{
                if(grid <= 506.5){
                    predict = 2404;
                }else{
                    predict = 7000;
                }
            }
            if(predict == fpredict)
                count++;
        }

}catch (Exception e){}
        out.print(count);
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

