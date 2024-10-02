package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise32342 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            String wow = br.readLine();
            int count = 0;
            while (wow.contains("WOW")) {
                count++;
                wow = wow.replaceFirst("WOW", "W");
            }
            System.out.println(count);
        }
    }
}
