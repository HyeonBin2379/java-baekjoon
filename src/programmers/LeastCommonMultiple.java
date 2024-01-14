package programmers;

import java.util.Arrays;

class LeastCommonMultipleSolution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-1; i++) {
            int gcd = GCD(arr[i], arr[i+1]);
            int lcm = arr[i]*arr[i+1] / gcd;
            arr[i+1] = lcm;
        }
        return arr[arr.length-1];
    }

    public int GCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return GCD(num2 % num1, num1);
    }
}
public class LeastCommonMultiple {
    public static void main(String[] args) {
        int[] arr = {2,6,8,14};
        System.out.println(new LeastCommonMultipleSolution().solution(arr));
    }
}
