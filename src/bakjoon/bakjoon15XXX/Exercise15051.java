package bakjoon.bakjoon15XXX;

import java.util.Scanner;

public class Exercise15051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cost = new int[3];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = sc.nextInt();
        }
        sc.close();

        System.out.println(Math.min(Math.min(cost[0]*2 + cost[1], cost[1]+cost[2]*2), cost[0]+cost[2])*2);
    }
}
