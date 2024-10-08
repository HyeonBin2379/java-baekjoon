package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Exercise32500 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] lottoNum = new int[51];
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < 10*n; i++) {
            Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(num -> lottoNum[num]++);
        }
        List<String> answer = new ArrayList<>();
        IntStream.rangeClosed(1, 50)
                .filter(num -> lottoNum[num] > n*2)
                .mapToObj(Integer::toString)
                .forEach(answer::add);
        System.out.println(answer.isEmpty() ? -1 : String.join(" ", answer));
    }
}
