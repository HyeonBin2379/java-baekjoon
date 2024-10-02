package baekjoon.baekjoon17XXX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise17968 {

    // a[i]의 값이 될 수 없는 정수값들의 리스트
    private static final List<Integer> wrongList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[1001];
        a[0] = a[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int k = 1; k <= i/2; ++k) {
                /* 2*a[i-k]-a[i-2*k] == a[i] 성립 시 주어진 정의에 위배되므로
                   변수 wrong의 값은 a[i]의 값이 될 수 없음 */
                int wrong = 2*a[i-k]-a[i-2*k];
                wrongList.add(wrong);
            }
            a[i] = findValue();
            wrongList.clear();
        }
        System.out.println(a[n]);
    }

    private static int findValue() {
        int minNum = 1;
        wrongList.sort(null);
        for (Integer wrong : wrongList) {
            // 2*a[i-k]-a[i-2*k] == a[i]이 성립할 경우 구하려는 정수의 최솟값은 1 증가
            if (minNum == wrong) {
                minNum++;
            }
        }
        return minNum;
    }
}
