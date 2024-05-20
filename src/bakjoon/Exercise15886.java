package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise15886 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] map = br.readLine().toCharArray();

        // 주어진 지도를 벗어나지 않음 = 맵의 각 칸마다 그 이전까지의 W의 개수는 E와 같거나 항상 적음, W는 맵 전체에 항상 존재
        // 지도에서는 방향이 바뀌는 지점, 즉 W->E 또는 E->W인 지점을 항상 거쳐야 함
        // 하지만 W->E를 고려하면 첫 칸부터 지도를 벗어나는 사례로 인해 문제 조건에 위배, 따라서 E->W의 개수 탐색
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (map[i-1] == 'E' && map[i] == 'W') {
                count++;
            }
        }
        System.out.println(count);
    }
}
