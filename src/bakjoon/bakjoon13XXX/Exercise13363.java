package bakjoon.bakjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise13363 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        int diff = num2-num1;
        if (diff > 180) {
            diff -= 360;
        } else if (diff <= -180){
            diff += 360;
        }
        System.out.println(diff);
    }
}
