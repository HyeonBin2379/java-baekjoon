package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise28115 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (!check(num)) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
        Arrays.stream(num).forEach(value -> System.out.print(value + " "));
        System.out.println();
        Arrays.stream(num).map(operand -> 0).forEach(value -> System.out.print(value + " "));
    }

    private static boolean check(int[] num) {
        int n = num.length;
        for (int i = 2; i < n; i++) {
            if (num[i]-num[i-1] != num[1]-num[0]) {
                return false;
            }
        }
        return true;
    }
}
