package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2997 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(num);
        if (num[1]-num[0] > num[2]-num[1]) {
            System.out.println(num[0] + (num[2]-num[1]));
        } else if (num[1]-num[0] == num[2]-num[1]) {
            System.out.println(num[2] + (num[1]-num[0]));
        } else {
            System.out.println(num[1] + (num[1] - num[0]));
        }
    }
}
