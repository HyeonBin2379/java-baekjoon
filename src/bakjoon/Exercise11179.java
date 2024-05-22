package bakjoon;

import java.util.Scanner;

public class Exercise11179 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
        int newNum = Integer.parseInt(sb.reverse().toString(), 2);
        System.out.println(newNum);
    }
}
