package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise32722 {

    private static final List<List<Integer>> path = new ArrayList<>(Arrays.asList(List.of(1, 3), List.of(6, 8), List.of(2, 5)));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = "JAH";
        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(br.readLine());
            if (!path.get(i).contains(num)) {
                answer = "EI";
            }
        }
        System.out.println(answer);
    }
}
