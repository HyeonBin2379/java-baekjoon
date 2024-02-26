package bakjoon;

import java.util.Scanner;

public class Exercise2863 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        double[] rotate = new double[4];
        rotate[0] = (double)a/c + (double)b/d;
        rotate[1] = (double)c/d + (double)a/b;
        rotate[2] = (double)d/b + (double)c/a;
        rotate[3] = (double)b/a + (double)d/c;

        int index = 0;
        for (int i = 0; i < 4; i++) {
            index = (rotate[index] < rotate[i]) ? i : index;
        }
        System.out.println(index);
    }
}
