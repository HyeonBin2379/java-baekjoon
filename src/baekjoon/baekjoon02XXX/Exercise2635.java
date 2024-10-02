package baekjoon.baekjoon02XXX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise2635 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        sc.close();

        List<Integer> maxList = new ArrayList<>(List.of(number));
        int max = 0;
        for (int i = 1; i < number+1; i++) {
            List<Integer> currentList = new ArrayList<>(List.of(number));
            currentList.add(i);
            int first = number;
            int second = i;
            while (first >= second) {
                int temp = first - second;
                currentList.add(temp);
                first = second;
                second = temp;
            }

            if (currentList.size() > max) {
                max = currentList.size();
                maxList = currentList;
            }
        }
        System.out.println(max);
        maxList.forEach(integer -> System.out.print(integer + " "));
    }
}
