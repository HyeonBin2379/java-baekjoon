package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (num[0]+num[1] == num[2]) {
            System.out.printf("%d+%d=%d", num[0], num[1], num[2]);
        } else if (num[0]-num[1] == num[2]) {
            System.out.printf("%d-%d=%d", num[0], num[1], num[2]);
        } else if (num[0]*num[1] == num[2]) {
            System.out.printf("%d*%d=%d", num[0], num[1], num[2]);
        } else if (num[0]/num[1] == num[2]) {
            System.out.printf("%d/%d=%d", num[0], num[1], num[2]);
        } else if (num[1]+num[2] == num[0]) {
            System.out.printf("%d=%d+%d", num[0], num[1], num[2]);
        } else if (num[1]-num[2] == num[0]) {
            System.out.printf("%d=%d-%d", num[0], num[1], num[2]);
        } else if (num[1]*num[2] == num[0]) {
            System.out.printf("%d=%d*%d", num[0], num[1], num[2]);
        } else {
            System.out.printf("%d=%d/%d", num[0], num[1], num[2]);
        }
    }
}
