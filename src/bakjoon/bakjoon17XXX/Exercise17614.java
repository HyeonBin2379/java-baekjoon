package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise17614 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 1; i <= num; i++) {
            String digit = Integer.toString(i);
            for (int j = 0; j < digit.length(); j++) {
                char letter = digit.charAt(j);
                if (letter == '3' || letter == '6' || letter == '9') {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
