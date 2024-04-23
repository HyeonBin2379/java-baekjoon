package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Exercise7218 {

    private static final String[] num = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        Set<Integer> result = new TreeSet<>();
        for (int i = 1; i <= 12; i++) {
            if (input.contains(num[i])) {
                result.add(i);
            }
        }
        result.forEach(value -> System.out.print(value + " "));
    }
}
