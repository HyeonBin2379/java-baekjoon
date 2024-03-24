package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1268 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[][] stuClass = new int[count+1][6]; // row: 학생번호, col: 학년

        // 각 학생의 학년별 분반 기록(입력값)
        for (int i = 1; i <= count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                stuClass[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 학생이 같은 반인 적 있는지 체크
        boolean[][] hasSameClass = new boolean[count+1][count+1];
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= count; j++) {
                for (int k = j+1; k <= count; k++) {
                    if (stuClass[j][i] == stuClass[k][i]) {
                        hasSameClass[j][k] = true;
                        hasSameClass[k][j] = true;
                    }
                }
            }
        }

        int[] cntSameStu = new int[count+1];
        int max = 0, answer = 1;
        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= count; j++) {
                if (hasSameClass[i][j]) {
                    cntSameStu[i]++;
                }
            }
            if (max < cntSameStu[i]) {
                max = cntSameStu[i];
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
