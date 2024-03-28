package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise14182 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int amount = Integer.parseInt(br.readLine());
            if (amount == 0) {
                break;
            }

            if (amount > 5000000) {
                amount = (amount*8)/10;
            } else if (amount > 1000000) {
                amount = (amount*9)/10;
            }
            System.out.println(amount);
        }
    }
}
