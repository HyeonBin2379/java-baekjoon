import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<Integer> scores = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            int score = sc.nextInt();
            scores.add(score);
        }

        int myMax = Collections.max(scores);
        int mySum = scores.stream().mapToInt(Integer::intValue).sum();

        System.out.println((double)mySum*100/myMax/num);
        sc.close();
    }
}