package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise5698 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] words = br.readLine().toLowerCase().split(" ");
            if (words[0].equals("*")) {
                break;
            }
            Set<Character> result = Arrays.stream(words).map(s -> s.charAt(0)).collect(Collectors.toSet());
            System.out.println(result.size() == 1 ? "Y" : "N");
        }
    }
}
