package bakjoon;

import java.util.Scanner;

public class Exercise17869 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        int count = 0;
        while (num != 1) {
            num = (num % 2 == 1) ? num+1 : num/2;
            count++;
        }
        System.out.println(count);
    }
}
