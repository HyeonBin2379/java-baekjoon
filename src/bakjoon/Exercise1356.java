package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1356 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for (int i = 1; i < input.length(); i++) {
            int temp1 = 1;
            for (int j = 0; j < i; j++) {
                temp1 *= (input.charAt(j) - '0');
            }
            int temp2 = 1;
            for (int j = i; j < input.length(); j++) {
                temp2 *= (input.charAt(j) - '0');
            }
            if (temp1 == temp2) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
