package bakjoon.bakjoon9XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise9151 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }

            int result = 0;
            for (int i = 1; i*i*i <= num; i++) {
                result = Math.max(result, i*i*i);
            }
            for (int i = 1; i*(i+1)*(i+2)/6 <= num; i++) {
                result = Math.max(result, i*(i+1)*(i+2)/6);
            }
            for (int i = 1; i*i*i <= num; i++) {
                for (int j = 1; j*(j+1)*(j+2)/6 <= num; j++) {
                    int temp = i*i*i + j*(j+1)*(j+2)/6;
                    if (temp > num) {
                        break;
                    }
                    result = Math.max(result, temp);
                }
            }
            System.out.println(result);
        }
    }
}
