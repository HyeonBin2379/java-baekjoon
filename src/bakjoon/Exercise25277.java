package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise25277 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> forbidden = new HashSet<>(List.of("he", "him", "she", "her"));
        int len = Integer.parseInt(br.readLine());
        String[] words = br.readLine().split(" ", len);
        System.out.println(Arrays.stream(words)
                .filter(forbidden::contains)
                .count());
    }
}
