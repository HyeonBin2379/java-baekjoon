package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise17588 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] num = new int[len];
        for (int i = 0; i < len; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        int index = 0;
        for (int i = 1; i <= num[len-1]; i++) {
            if (i != num[index]) {
                System.out.println(i);
            } else {
                index++;
            }
        }
        if (num[len-1] == len) {
            System.out.println("good job");
        }
    }
}
