package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise6751 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine())+1;
        while (true) {
            Set<Integer> digit = Arrays.stream(Integer.toString(year).split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());
            if (Integer.toString(year).length() == digit.size()) {
                break;
            }
            year++;
        }
        System.out.println(year);
    }
}
