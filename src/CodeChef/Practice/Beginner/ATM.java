package CodeChef.Practice.Beginner;

import java.util.Scanner;

/**
 * Created by asoni on 10-2-16.
 */
public class ATM {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int withdrawl = scanner.nextInt();
        double totalMoney = scanner.nextDouble();
        if (withdrawl % 5 != 0 || ((int) totalMoney) <= withdrawl) {
            System.out.printf("%.2f", totalMoney);
            return;
        }
        System.out.printf("%.2f", totalMoney - withdrawl - .5);
    }
}
