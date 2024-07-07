package bakjoon.bakjoon03XXX;

import java.util.Scanner;

public class Exercise3486 {

    // 숫자를 반전시키는 메소드
    public static int reverse(int number) {
        int reversed = 0;
        while (number != 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력받는 케이스 수
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            // 두 숫자를 입력받음
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();

            // 두 숫자를 반전시킴
            int reversedNum1 = reverse(num1);
            int reversedNum2 = reverse(num2);

            // 반전된 숫자들을 더함
            int sum = reversedNum1 + reversedNum2;

            // 더한 결과를 반전시킴
            int reversedSum = reverse(sum);

            // 결과를 출력
            System.out.println(reversedSum);
        }

        scanner.close();
    }
}
