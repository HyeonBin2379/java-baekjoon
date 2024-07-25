package bakjoon.bakjoon24XXX;

import java.util.Scanner;

public class Exercise24389 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = Integer.toString(sc.nextInt(), 2);
        int answer = 32;
        for (int i = binary.length()-1; i >= 0; i--) {
            answer--;
            if (binary.charAt(i) == '1') {
                break;
            }
        }
        System.out.println(answer);
    }
}
