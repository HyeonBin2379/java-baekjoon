package bakjoon.bakjoon6XXX;

import java.util.Scanner;

public class Exercise6764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] depth = new int[4];
        for (int i = 0; i < 4; i++) {
            depth[i] = sc.nextInt();
        }
        sc.close();

        int comparison = Integer.compare(depth[0], depth[1]);
        for (int i = 1; i < 3; i++) {
            if (comparison != Integer.compare(depth[i], depth[i+1])) {
                System.out.println("No Fish");
                return;
            }
        }
        switch (comparison) {
            case -1 -> System.out.println("Fish Rising");
            case 0 -> System.out.println("Fish At Constant Depth");
            case 1 -> System.out.println("Fish Diving");
        }
    }
}
