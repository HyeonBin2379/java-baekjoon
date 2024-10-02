package baekjoon.baekjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise24387 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] price = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] container = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(price);
        Arrays.sort(container);

        long answer = 0;
        for (int i = 0; i < 3; i++) {
            answer += (price[i]*container[i]);
        }
        System.out.println(answer);
    }
}
