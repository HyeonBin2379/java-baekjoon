package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise20359 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int exp = 0;
        while (num % 2 == 0) {
            num /= 2;
            exp++;
        }
        System.out.println(num + " " + exp);
    }
}
