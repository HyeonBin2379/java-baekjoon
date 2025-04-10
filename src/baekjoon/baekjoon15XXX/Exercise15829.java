package baekjoon.baekjoon15XXX;

import java.util.Scanner;

public class Exercise15829 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = Integer.parseInt(sc.nextLine());
        char[] input = sc.nextLine().toCharArray();

        long answer = 0;
        long power = 1;
        for (int i = 0; i < l; i++) {
            answer += power * (input[i]-'a'+1) % 1234567891;
            power = (power * 31) % 1234567891;
        }
        System.out.println(answer % 1234567891);
    }
}
