package bakjoon;

import java.util.Scanner;

public class Exercise25703 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();
        sb.append("int a;\n");
        for (int i = 1; i <= num; i++) {
            sb.append(String.format("int %sptr", "*".repeat(i)));
            sb.append((i == 1) ? " = &a;\n" : (i == 2) ? String.format("%d = &ptr;\n", i) : String.format("%d = &ptr%d;\n", i, i-1));
        }
        System.out.print(sb);
    }
}
