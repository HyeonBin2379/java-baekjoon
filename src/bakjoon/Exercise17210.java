package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise17210 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int pushed = Integer.parseInt(br.readLine());
        if (n > 5) {
            System.out.println("Love is open door");
            return;
        }
        for (int i = 2; i <= n; i++) {
            if (pushed == 0) {
                System.out.println((i+1) % 2);
            } else {
                System.out.println(i % 2);
            }
        }
    }
}
