package bakjoon.bakjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise3181 {

    private static final List<String> notNecessary = new ArrayList<>(List.of("i", "pa", "te", "ni", "niti", "a", "ali", "nego", "no", "ili"));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] words = br.readLine().split(" ");

        for (int i = 0; i < words.length; i++) {
            if (!notNecessary.contains(words[i])
                    || (notNecessary.contains(words[i]) && i == 0)) {
                sb.append(words[i].charAt(0));
            }
        }
        System.out.println(sb.toString().toUpperCase());
    }
}
