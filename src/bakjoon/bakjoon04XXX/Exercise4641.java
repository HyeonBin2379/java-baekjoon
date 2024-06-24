package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise4641 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("-1")) {
                break;
            }
            int[] num = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt)
                    .filter(value -> value != 0)
                    .sorted()
                    .toArray();
            int count = 0;
            for (int i = 0; i < num.length-1; i++) {
                for (int j = i+1; j < num.length; j++) {
                    if (num[j] % num[i] == 0 && num[j]/num[i] == 2) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
