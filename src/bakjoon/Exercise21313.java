package bakjoon;

import java.util.Scanner;

public class Exercise21313 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int half = num/2;
        for (int i = 0; i < half; i++) {
            System.out.print("1 2 ");
        }
        if (num % 2 == 1) {
            System.out.println(3);
        }
    }
}
