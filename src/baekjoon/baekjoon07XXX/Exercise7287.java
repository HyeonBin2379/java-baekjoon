package baekjoon.baekjoon07XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise7287 {
    private static final int[][] studentCount = new int[2][7];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            studentCount[gender][grade]++;
        }
        br.close();

        int roomCount = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 7; j++) {
                if (studentCount[i][j] == 0) {
                    continue;
                }
                roomCount += (studentCount[i][j] % K == 0) ? studentCount[i][j] / K : (studentCount[i][j] / K) + 1;
            }
        }
        System.out.println(roomCount);
    }
}
