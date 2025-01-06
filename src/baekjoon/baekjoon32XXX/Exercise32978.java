package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Exercise32978 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] names = br.readLine().split(" ");
        List<String> ingredients = Arrays.asList(br.readLine().split(" ", n));
        for (int i = 0; i < n; i++) {
            if (!ingredients.contains(names[i])) {
                System.out.println(names[i]);
                break;
            }
        }
    }
}
