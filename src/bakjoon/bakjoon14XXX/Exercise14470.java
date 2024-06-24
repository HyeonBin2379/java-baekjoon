package bakjoon.bakjoon14XXX;

import java.util.Scanner;

public class Exercise14470 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int underDegree = sc.nextInt();
        int thawing = sc.nextInt();
        int heating = sc.nextInt();
        sc.close();

        int totalTime;
        if (start <= 0) {
            totalTime = thawing + end*heating;
            if (start < 0) {
                totalTime += (-start)*underDegree;
            }
        } else {
            totalTime = (end - start) * heating;
        }
        System.out.println(totalTime);
    }
}
