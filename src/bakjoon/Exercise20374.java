package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise20374 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        long sum = 0L;
        while ((input = br.readLine()) != null) {
            sum += (Long.parseLong(input.substring(0, input.length()-3))*100
                    + Long.parseLong(input.substring(input.length()-2)));
        }
        System.out.printf("%.2f\n", sum/100.0);
    }
}
