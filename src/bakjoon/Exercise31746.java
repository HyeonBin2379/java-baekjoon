package bakjoon;

import java.util.Scanner;

public class Exercise31746 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        StringBuilder sb = new StringBuilder("SciComLove");
        if (num % 2 == 1) {
            System.out.println(sb.reverse());
        } else {
            System.out.println(sb);
        }
    }
}
