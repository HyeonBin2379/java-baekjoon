package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise30403 {
    private static final Set<String> smallRainbow = Set.of("r", "o", "y", "g", "b", "i", "v");
    private static final Set<String> bigRainbow = Set.of("R", "O", "Y", "G", "B", "I", "V");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> input = Arrays.stream(br.readLine().split("")).collect(Collectors.toSet());

        if (input.containsAll(smallRainbow)) {
            System.out.println(input.containsAll(bigRainbow) ? "YeS" : "yes");
        } else {
            System.out.println(input.containsAll(bigRainbow) ? "YES" : "NO!");
        }
    }
}
