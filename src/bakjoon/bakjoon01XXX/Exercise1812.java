package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise1812 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> adjSum = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < n; i++) {
            int sum = Integer.parseInt(br.readLine());
            adjSum.add(sum);
            num += (i % 2 == 0) ? sum : -sum;
        }
        List<Integer> answer = new ArrayList<>();
        answer.add(num/2);
        for (int i = 0; i < n-1; i++) {
            int nextNum = adjSum.get(i) - answer.get(i);
            answer.add(nextNum);
        }
        answer.forEach(System.out::println);
    }
}
