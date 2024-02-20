package bakjoon;

import java.util.Scanner;

public class Exercise14935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        sc.close();

        String prev = number;
        while (true) {
            String[] temp = prev.split("");
            if (temp.length == 1) {
                break;
            }
            prev = String.valueOf(Integer.parseInt(temp[0]) * temp.length);
        }
        System.out.println("FA");
    }
}
