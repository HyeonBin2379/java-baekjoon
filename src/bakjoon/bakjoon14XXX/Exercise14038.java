package bakjoon.bakjoon14XXX;

import java.util.Scanner;

public class Exercise14038 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int winCount = 0;
        for (int i = 0; i < 6; i++) {
            String game = sc.nextLine();
            winCount += (game.equals("W")) ? 1 : 0;
        }
        switch (winCount) {
            case 5, 6 -> System.out.println(1);
            case 3, 4 -> System.out.println(2);
            case 1, 2 -> System.out.println(3);
            case 0 -> System.out.println(-1);
        }
    }
}
