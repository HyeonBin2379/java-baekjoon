package bakjoon.bakjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise29666 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> password = new HashSet<>(List.of("123", "456", "789", "147", "258", "369", "025", "058"));
        String input = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());

        if (password.contains(input)) {
            System.out.println("Unlocked");
        } else {
            System.out.println("Locked");
        }
    }
}
