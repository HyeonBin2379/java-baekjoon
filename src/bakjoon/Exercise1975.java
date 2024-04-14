package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1975 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(br.readLine());
            int count = 0;
            for (int j = 2; j <= num; j++) {
                if (num % j == 0) {
                    int temp = num;
                    while (temp > 0) {
                        if (temp % j != 0) {
                            break;
                        }
                        count++;
                        temp /= j;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
