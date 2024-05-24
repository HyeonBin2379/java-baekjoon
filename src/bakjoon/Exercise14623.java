package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise14623 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num1 = Long.parseLong(br.readLine(), 2);
        long num2 = Long.parseLong(br.readLine(), 2);
        System.out.println(Long.toBinaryString(num1 * num2));
    }
}
