package baekjoon.baekjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise24303 {

    private static class Stick {
        int len, count;
        public Stick(int len, int count) {
            this.len = len;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Stick> basket = new ArrayList<>();
        int len = input[6];
        for (int i = 0; i < 3; i++) {
            basket.add(new Stick(input[i], input[i+3]));
        }
        basket.sort((o1, o2) -> o2.len-o1.len);

        int sum = 0;
        int count = 0;
        for (Stick stick : basket) {
            for (int i = 0; i < stick.count; i++) {
                if (sum >= len) {
                    break;
                }
                sum += stick.len;
                count++;
            }
        }
        System.out.println(sum < len ? 0 : count);
    }
}
