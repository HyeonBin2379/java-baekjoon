package bakjoon.bakjoon13XXX;

import java.util.Scanner;

public class Exercise13236 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while (num != 1) {
            System.out.print(num + " ");
            num = (num % 2 == 0) ? num/2 : 3*num+1;
        }
        System.out.println(num);
    }
}
