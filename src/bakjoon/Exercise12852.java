package bakjoon;

import java.util.Scanner;

public class Exercise12852 {
    private static final int[] move = {-1, 3, 2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();

        int[] array = new int[num + 1];
        int[] before = new int[num + 1];
        for (int i = 2; i < array.length; i++) {
            for (int next : move) {
                if (next < 0) {
                    array[i] = array[i+next]+1;
                    before[i] = i+next;
                    continue;
                }

                if (i % next == 0) {
                    array[i] = Math.min(array[i], array[i/next]+1);
                    if (array[i] == array[i/next]+1) {
                        before[i] = i / next;
                    }
                }
            }
        }
        System.out.println(array[num]);

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num).append(" ");
            num = before[num];
        }
        System.out.print(sb);
    }
}
