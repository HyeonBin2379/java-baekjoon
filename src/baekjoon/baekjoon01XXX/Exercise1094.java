package baekjoon.baekjoon01XXX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise1094 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> sticks = new ArrayList<>(List.of(64));
        int length = sc.nextInt();
        int sum = sticks.stream().mapToInt(value -> value).sum();

        while (sum != length) {
            sticks.sort((o1, o2) -> o2 - o1);
            int newStick = sticks.get(sticks.size()-1) / 2;
            sticks.set(sticks.size()-1, newStick);
            if (sum - newStick >= length) {
                sum -= newStick;
                continue;
            }
            sticks.add(newStick);
        }

        System.out.println(sticks.size());
        sc.close();
    }
}
