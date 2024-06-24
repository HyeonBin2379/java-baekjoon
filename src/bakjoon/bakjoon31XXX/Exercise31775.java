package bakjoon.bakjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise31775 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> global = new HashSet<>(List.of('k', 'l', 'p'));
        Set<Character> result = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            String logo = br.readLine();
            if (!global.contains(logo.charAt(0))) {
                System.out.println("PONIX");
                return;
            }
            result.add(logo.charAt(0));
        }
        System.out.println(global.equals(result) ? "GLOBAL" : "PONIX");
    }
}
