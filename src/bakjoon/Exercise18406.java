package bakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise18406 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        int[] prefixSum = new int[num.length+1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i-1] + num[i-1];
        }
        if (prefixSum[num.length/2]-prefixSum[0] == prefixSum[num.length]-prefixSum[num.length/2]) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
