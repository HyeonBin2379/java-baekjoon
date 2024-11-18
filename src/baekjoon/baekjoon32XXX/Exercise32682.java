package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise32682 {

    private static final List<Integer> squares = getList();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            String answer = "";
            if (num % 2 == 1) {
                answer += "O";
            }
            if (squares.contains(num)) {
                answer += "S";
            }
            System.out.println(answer.isEmpty() ? "EMPTY" : answer);
        }
    }

    private static List<Integer> getList() {
        return IntStream.rangeClosed(0, 1000)
                .map(num -> num*num)
                .boxed()
                .collect(Collectors.toList());
    }
}
