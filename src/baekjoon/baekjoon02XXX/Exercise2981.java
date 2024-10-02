package baekjoon.baekjoon02XXX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise2981 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int[] numbers = new int[testCase];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);

        // numbers[i]-numbers[i-1]의 최대공약수 M 구하기
        int gcdM = numbers[1] - numbers[0];
        for (int i = 1; i < numbers.length-1; i++) {
            gcdM = euclidean(gcdM, numbers[i+1] - numbers[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= gcdM; i++) {
            if (gcdM % i == 0) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
        sc.close();
    }

    public static int euclidean(int a, int b) {
        return (a % b > 0) ? euclidean(b, a%b) : b;
    }
}
