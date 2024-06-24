package bakjoon.bakjoon20XXX;

import java.util.Scanner;

public class Exercise20360 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = Integer.toBinaryString(sc.nextInt());
        int len = binary.length();
        for (int i = len-1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                System.out.print(len-1-i + " ");
            }
        }
    }
}
