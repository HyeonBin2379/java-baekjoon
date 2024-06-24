package bakjoon.bakjoon24XXX;

import java.util.Scanner;

public class Exercise24079 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        sc.close();
        System.out.println((x+y)*60 <= z*60+30 ? 1 : 0);
    }
}
