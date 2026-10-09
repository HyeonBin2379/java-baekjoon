import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // a의 변속 횟수
        int m = sc.nextInt();   // b의 변속 횟수

        int[][] A = new int[n][2];
        for (int i = 0; i < n; i++) {
            A[i][0] = sc.nextInt();     // a의 속도
            A[i][1] = sc.nextInt();     // a의 이동 시간
        }
        int[][] B = new int[m][2];
        for (int i = 0; i < m; i++) {
            B[i][0] = sc.nextInt();     // b의 속도
            B[i][1] = sc.nextInt();     // b의 이동 시간
        }
        // Please write your code here.

        int[] timeLineA = getTimeLine(n, A);
        int[] timeLineB = getTimeLine(m, B);

        int[] race = new int[1000001];
        int len = timeLineA.length;
        for (int i = 0; i < len; i++) {
            race[i] = timeLineA[i]-timeLineB[i];
        }

        long prev = race[0];
        int answer = 0;
        for (int i = 1; i < len; i++) {
            if (race[i]*prev < 0) {
                answer++;
            }
            if (race[i] != 0) {
                prev = race[i];
            }
        }
        System.out.println(answer);
    }

    private static int[] getTimeLine(int len, int[][] player) {
        int[] timeLine = new int[1000001];
        int index = 0;
        timeLine[index] = 0;

        for (int i = 0; i < len; i++) {
            int curr = timeLine[index];
            for (int j = 1; j <= player[i][1]; j++) {
                curr += player[i][0];
                timeLine[++index] = curr;
            }
        }
        return timeLine;
    }
}