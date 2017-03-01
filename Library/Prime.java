package Library;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asoni on 8/31/2016.
 */
public class Prime {

    /**
     * This method retuens the List of primes upto upparBound
     * TimeComplexity nlog(logn)
     * SpaceComplexity n
     * @param upperBound
     * @return
     */
    public static List runEratosthenesSieve(int upperBound) {
        int upperBoundSquareRoot = (int) Math.sqrt(upperBound);
        boolean[] isComposite = new boolean[upperBound + 1];
        List<Integer> primes = new ArrayList<Integer>();
        for (int m = 2; m <= upperBoundSquareRoot; m++) {
            if (!isComposite[m]) {
                primes.add(m);
                for (int k = m * m; k <= upperBound; k += m)
                    isComposite[k] = true;
            }
        }
        for (int m = upperBoundSquareRoot; m <= upperBound; m++)
            if (!isComposite[m])
                primes.add(m);
        return primes;
    }
}
