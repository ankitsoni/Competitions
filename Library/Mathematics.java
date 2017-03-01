package Library;

/**
 * Created by asoni on 8/21/2016.
 */
public class Mathematics {
    public static void main(String[] args) {
        Maths maths = new Maths();
        System.out.println(maths.gcdRecursive(50,60));
        System.out.println(maths.gcdIterative(50,60));
        System.out.println(maths.gcdIterative(60,50));
    }
    private static class Maths{
        /**
         * Finds gcd By Euclid Recursively
         * @param a
         * @param b
         * @return
         */
        long gcdRecursive(long a, long b){
            a = Math.abs(a); b = Math.abs(b);
            return (b==0) ? a : gcdRecursive(b, a%b);
        }

        /**
         * Finds gcd by Euclid Iteratively
         * @param a
         * @param b
         * @return
         */
        long gcdIterative(long a, long b) {
            long r, i;
            while(b!=0){
                r = a % b;
                a = b;
                b = r;
            }
            return a;
        }

        /**
         * Finds gcd by Euclid algo and bit manipulation
         * @param a
         * @param b
         * @return
         */
        int gcd(int a, int b)
        {
            while(b!=0) b ^= a ^= b ^= a %= b;
            return a;
        }
    }
}
