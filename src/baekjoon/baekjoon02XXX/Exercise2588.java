package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2588 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());

        int result = 0;
        int pow = 0;
        while (num2 > 0) {
            int temp = num1*(num2 % 10);
            System.out.println(temp);
            result += temp * (int) Math.pow(10, pow);
            num2 /= 10;
            pow++;
        }
        System.out.println(result);
    }
}
