package bakjoon;

import java.io.IOException;
import java.util.Scanner;

public class Exercise13610 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int answer = 1;
        while ((y-x)*answer < y) {
            answer++;
        }
        System.out.println(answer);
    }
}
