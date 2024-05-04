package bakjoon;

import java.util.Scanner;

public class Exercise29196 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        input = input.substring(2);
        int num1 = Integer.parseInt(input);
        int num2 = (input.length() > 1 && input.charAt(0) == input.charAt(input.length() - 1))
                ? Integer.parseInt("9".repeat(input.length()))
                : (int) Math.pow(10, input.length());
        int gcd = getGCD(num1, num2);
        System.out.println("YES");
        System.out.println((num1/gcd) + " " + (num2/gcd));
    }

    private static int getGCD(int num1, int num2) {
        while (num1 > 0) {
            int temp = num2 % num1;
            num2 = num1;
            num1 = temp;
        }
        return num2;
    }
}
