package bakjoon;

import java.util.Scanner;

public class Exercise28295 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] direction = {"N", "E", "S", "W"};
        int index = 0;
        for (int i = 1; i <= 10; i++) {
            int cmd = sc.nextInt();
            switch (cmd) {
                case 1 -> index += 1;
                case 2 -> index += 2;
                case 3 -> index += 3;
            }
        }
        sc.close();
        System.out.println(direction[index % 4]);
    }
}
