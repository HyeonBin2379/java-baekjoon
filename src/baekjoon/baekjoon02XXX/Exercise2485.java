package baekjoon.baekjoon02XXX;

import java.util.Scanner;

public class Exercise2485 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] streetTree = new int[N];
        for (int i = 0; i < streetTree.length; i++) {
            streetTree[i] = sc.nextInt();
        }

        int gcd = streetTree[1] - streetTree[0];
        for (int i = 1; i < streetTree.length-1; i++) {
            gcd = euclidean(gcd, streetTree[i+1] - streetTree[i]);
        }

        int count = 0;
        for (int i = 1; i < streetTree.length; i++) {
            int distance = streetTree[i] - streetTree[i-1];
            if (distance > gcd) {
                count += (distance / gcd) - 1;
            }
        }
        System.out.println(count);
        sc.close();
    }

    public static int euclidean(int a, int b) {
        return (a % b > 0) ? euclidean(b, a%b) : b;
    }
}
