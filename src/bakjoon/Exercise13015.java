package bakjoon;

import java.util.Scanner;

public class Exercise13015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2*size-1; i++) {
            if (i == 0 || i == 2*(size-1)) {
                sb.append("*".repeat(Math.max(0, size)));
                sb.append(" ".repeat(Math.max(0, 2 * size - 3)));
                sb.append("*".repeat(Math.max(0, size)));
            } else if (i == size-1) {
                sb.append(" ".repeat(i));
                sb.append("*");
                sb.append(" ".repeat(Math.max(0, size - 2)));
                sb.append("*");
                sb.append(" ".repeat(Math.max(0, size - 2)));
                sb.append("*");
            } else if (i < size-1) {
                sb.append(" ".repeat(i));
                sb.append("*");
                sb.append(" ".repeat(Math.max(0,size-2)));
                sb.append("*");
                sb.append(" ".repeat(Math.max(0,2*size-3-2*i)));
                sb.append("*");
                sb.append(" ".repeat(Math.max(0,size-2)));
                sb.append("*");
            } else {
                sb.append(" ".repeat(Math.max(0,2*(size-1)-i)));
                sb.append("*");
                sb.append(" ".repeat(Math.max(0,size-2)));
                sb.append("*");
                sb.append(" ".repeat(Math.max(0,(i-(size-1))*2-1)));
                sb.append("*");
                sb.append(" ".repeat(Math.max(0,size-2)));
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
