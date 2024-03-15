package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise25495 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] phone = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int now = 0;
        int result = 0;
        int connected = 0;
        for (int i = 0; i < n; i++) {
            if (connected == phone[i]) {
                now *= 2;
            } else {
                connected = phone[i];
                now = 2;
            }
            result += now;

            if (result >= 100) {
                now = 0;
                result = 0;
                connected = 0;
            }
        }
        System.out.println(result);
    }
}
