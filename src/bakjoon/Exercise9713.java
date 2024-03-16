package bakjoon;

import java.util.Scanner;

public class Exercise9713 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testCase; i++) {
            int num = sc.nextInt();
            int val = (num+1)/2;
            System.out.println(val*val);
        }
    }
}
