package bakjoon.bakjoon16XXX;

import java.util.Scanner;

public class Exercise16561 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        num = (num/3)-2;
        System.out.println(num*(num+1)/2);
    }
}
