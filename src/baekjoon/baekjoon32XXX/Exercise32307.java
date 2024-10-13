package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise32307 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> dictionary = new ArrayList<>();
        while (n-- > 0) {
            String word = br.readLine();
            dictionary.add(word);
        }
        Set<String> combined = new HashSet<>();
        for (String s1 : dictionary) {
            for (String s2 : dictionary) {
                combined.add(s1+s2);
            }
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            String input = br.readLine();
            if (dictionary.contains(input)) {
                System.out.println(1);
            } else if (combined.contains(input)) {
                System.out.println(2);
            } else {
                System.out.println(0);
            }
        }
    }
}
