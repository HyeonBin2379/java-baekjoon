package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise4564 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }
            List<String> result = new ArrayList<>(List.of(input));
            while (input.length() > 1) {
                int num = Arrays.stream(input.split(""))
                        .mapToInt(Integer::parseInt)
                        .reduce(1, (a, b) -> a*b);
                input = Integer.toString(num);
                result.add(input);
            }
            System.out.println(String.join(" ", result));
        }
    }
}
