package bakjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise14916 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>(List.of(-1, -1, 1, -1, 2, 1, 3, 2, 4, 3));
        int num = sc.nextInt();
        for (int i = 10; i <= num; i++) {
            list.add(list.get(i-5)+1);
        }
        System.out.println(list.get(num));
    }
}
