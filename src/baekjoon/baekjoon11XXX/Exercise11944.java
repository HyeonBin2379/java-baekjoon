package baekjoon.baekjoon11XXX;

import java.util.Scanner;

public class Exercise11944 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String result = Integer.toString(n).repeat(n);
        System.out.println(result.length() > m ? result.substring(0, m) : result);
    }
}
