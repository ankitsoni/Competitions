package Google.CodeJam8April2016;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 30-4-16.
 */
public class CloseMatch {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        int counter = 1;
        do {
            String c = in.next();
            String j = in.next();
            int C = 0, J = 0;
            int len = c.length();
            StringBuilder csb = new StringBuilder();
            StringBuilder jsb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                if (c.charAt(i) == '?') {
                    if (j.charAt(i) == '?') {
                        if (C > J) {
                            csb.append(0);
                            jsb.append(9);
                        } else if (J > C) {
                            csb.append(9);
                            jsb.append(0);
                        } else {
                            csb.append(0);
                            jsb.append(0);
                        }
                    } else {
                        if (C > J) {
                            csb.append(0);
                            jsb.append(j.charAt(i));
                        } else if (J > C) {
                            csb.append(9);
                            jsb.append(j.charAt(i));
                        } else {
                            csb.append(j.charAt(i));
                            jsb.append(j.charAt(i));
                        }
                    }
                } else {
                    if (j.charAt(i) == '?') {
                        if (C > J) {
                            csb.append(c.charAt(i));
                            jsb.append(9);
                        } else if (J > C) {
                            csb.append(c.charAt(i));
                            jsb.append(0);
                        } else {
                            csb.append(c.charAt(i));
                            jsb.append(c.charAt(i));
                        }
                    } else {
                        if (C > J) {
                            csb.append(c.charAt(i));
                            jsb.append(j.charAt(i));
                        } else if (J > C) {
                            csb.append(c.charAt(i));
                            jsb.append(j.charAt(i));
                        } else {
                            csb.append(c.charAt(i));
                            jsb.append(j.charAt(i));
                        }
                    }
                }
                int com = csb.toString().compareTo(jsb.toString());
                if(com > 0){
                    C=1;
                    J=0;
                }else if(com< 0){
                    J=1;
                    C=0;
                }else{
                    C=0;
                    J=0;
                }
            }
            out.println("Case #" + (counter++) + ": " + csb + " " + jsb);
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

