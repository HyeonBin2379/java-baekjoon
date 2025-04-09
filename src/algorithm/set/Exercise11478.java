package algorithm.set;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise11478 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Set<String> answer = new HashSet<>();
        for (int i = 1; i <= input.length(); i++) {
            for (int j = 0; j <= input.length()-i; j++) {
                answer.add(input.substring(j, j+i));
            }
        }
        System.out.println(answer.size());
    }
}
