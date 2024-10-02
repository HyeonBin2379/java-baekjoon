package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Exercise2592 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> numCount = new TreeMap<>();
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            numCount.put(num, numCount.getOrDefault(num, 0)+1);
        }

        System.out.println(sum / 10);
        System.out.println(numCount.keySet().stream().max(Comparator.comparingInt(numCount::get)).get());
    }
}
