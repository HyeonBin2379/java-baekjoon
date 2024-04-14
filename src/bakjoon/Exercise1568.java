package bakjoon;

import java.util.Scanner;

public class Exercise1568 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int answer = 0;
        int sum = 0;
        while (sum < num) {
            for (int i = 1; i <= num; i++) {
                if (i > num-sum) {
                    break;
                }
                answer++;
                sum += i;
            }
        }
        System.out.println(answer);
    }
}
