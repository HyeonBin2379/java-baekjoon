package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise6750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> rotatable = new HashSet<>(List.of("I", "O", "S", "H", "X", "Z", "N"));
        String[] input = br.readLine().split("");
        for (String s : input) {
            if (!rotatable.contains(s)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
