package bakjoon.bakjoon02XXX;

import java.util.Scanner;

public class Exercise2909 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int k = sc.nextInt();
        double money = Math.pow(10, k);
        int answer = (int) (Math.round(c/money)*money);
        System.out.println(answer);
    }
}
