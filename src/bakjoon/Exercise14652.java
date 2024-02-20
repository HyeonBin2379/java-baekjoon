package bakjoon;

import java.util.Scanner;

public class Exercise14652 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int target = sc.nextInt();
        sc.close();
        System.out.println(target/col + " " + target % col);
    }
}
