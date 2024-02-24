package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise25784 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        Arrays.sort(num);
        if (num[0]+num[1] == num[2]) {
            System.out.println(1);
        } else if (num[0]*num[1] == num[2]) {
            System.out.println(2);
        } else {
            System.out.println(3);
        }
    }
}
