package bakjoon;

import java.util.Scanner;

public class Exercise26741 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.printf("%d %d\n", (4*x-y)/2, (y-2*x)/2);
    }
}
