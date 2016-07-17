package CodeChef.Practice.Beginner;

import java.util.Scanner;

/**
 * Created by asoni on 9-2-16.
 * https://www.codechef.com/problems/TEST
 */
public class LifeTheUniverseAndEverything {

    public static void main(String[] args) {
        int a;
        Scanner scanner = new Scanner(System.in);
        while (true){
            a=scanner.nextInt();
            if (a==42)break;
            System.out.println(a);
        }
    }
}
