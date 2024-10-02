package baekjoon.baekjoon08XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Exercise8538 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> firstNames = new HashSet<>();

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String input = String.join("", br.readLine().toUpperCase().split("-"));
            firstNames.add(input);
        }
        System.out.println(firstNames.size());
    }
}
