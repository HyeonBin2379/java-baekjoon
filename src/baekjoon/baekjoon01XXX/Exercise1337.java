package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise1337 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(numbers);

        int answer = 4;
        for (int i = 0; i < n; i++) {
            int end = n-1;
            while (i < end) {
                if (numbers.get(end)-numbers.get(i) < 5) {
                    answer = Math.min(4-(end-i), answer);
                    break;
                }
                end--;
            }
        }
        System.out.println(answer);
    }
}
