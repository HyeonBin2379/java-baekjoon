package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise31713 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int answer = 0;

            // 줄기, 잎의 개수가 조건을 충족할 때까지 반복
            // 매 반복마다 현재 줄기, 잎을 기준으로 다음에 줄기, 잎 중 어느 것을 가져올지를 선택
            while (true) {
                if (b >= 3*a && b <= 4*a) {
                    System.out.println(answer);
                    break;
                } else if (b < 3*a) {
                    int neededLeaf = 3*a - b;
                    b += neededLeaf;
                    answer += neededLeaf;
                } else {
                    // 항상 최소 1개 이상의 줄기를 새로 가져올 수 있도록 3을 추가로 더한다.
                    int neededStem = (b-4*a+3)/4;   // b-4*a의 최솟값은 1
                    a += neededStem;
                    answer += neededStem;
                }
            }
        }
    }
}
