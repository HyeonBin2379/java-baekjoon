package bakjoon.bakjoon17XXX;

import java.util.Scanner;

public class Exercise17293 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        for (int i = n; i >= 1; i--) {
            if (i > 1) {
                sb.append(String.format("%d bottles of beer on the wall, %d bottles of beer.\n", i, i));
            } else {
                sb.append("1 bottle of beer on the wall, 1 bottle of beer.\n");
            }
            if (i-1 > 1) {
                sb.append(String.format("Take one down and pass it around, %d bottles of beer on the wall.\n\n", i-1));
            } else if (i-1 == 1) {
                sb.append("Take one down and pass it around, 1 bottle of beer on the wall.\n\n");
            } else {
                sb.append("Take one down and pass it around, no more bottles of beer on the wall.\n\n");
            }
        }

        sb.append("No more bottles of beer on the wall, no more bottles of beer.\n");
        if (n > 1) {
            sb.append(String.format("Go to the store and buy some more, %d bottles of beer on the wall.\n", n));
        } else {
            sb.append("Go to the store and buy some more, 1 bottle of beer on the wall.\n");
        }
        System.out.print(sb);
    }
}
