package MarketShare;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by asoni on 31-3-16.
 */
public  class integerC{

        private int i;
        public void setValue(int i)
        {
            i = this.i;
            return;
        }

        public static void updateInteger( integerC a)
        {
            integerC b = new integerC();
            a.setValue(299);
            return;
        }

        public int getValue()
        {
            return 399;
        }

        public static void main(String[] s)
        {
            integerC a = null;
            updateInteger( a);
            a.setValue(499);
            System.out.println("Value of I is:" +a.getValue() );
        }
    }


