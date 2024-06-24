package bakjoon.bakjoon25XXX;

import java.util.Scanner;

public class Exercise25704 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stamp = sc.nextInt();
        int price = sc.nextInt();
        sc.close();

        int[] discount = new int[4];
        discount[0] = price - 500;
        discount[1] = price * 9 / 10;
        discount[2] = price - 2000;
        discount[3] = price * 3 / 4;

        int min = price;
        for (int i = 0; i < discount.length; i++) {
            if ((i+1)*5 > stamp) {
                break;
            }
            min = Math.min(discount[i], min);
        }
        System.out.println(Math.max(min, 0));
    }
}
